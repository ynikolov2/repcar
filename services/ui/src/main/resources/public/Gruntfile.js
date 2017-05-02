/**
 * Created by mmanchev on 7/28/2016.
 */
module.exports = function(grunt) {


    var jsDependencyFileArray = [
        "node_modules/angular-/angular.js",
        "node_modules/angular-animate/angular-animate.js",
        "node_modules/angular-ui-router/angular-ui-router.js",
        "node_modules/angular-resource/angular-resource.js",

        "js/**/*.js"
    ];
    var jsScriptTags = function (srcPattern, destPath) {
        if (srcPattern === undefined) {
            throw new Error("srcPattern undefined");
        }
        if (destPath === undefined) {
            throw new Error("destPath undefined");
        }
        return grunt.util._.reduce(
            grunt.file.expand({
                filter: 'isFile',
                flatten: true,
                expand: true,
                cwd: '.'
            }, srcPattern),
            function (sum, file) {
                return sum + '\n<script src="' + file + '" type="text/javascript"></script>';
            },
            ''
        );
    };

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        jsScriptTags: jsScriptTags,
        jsSrcFileArray: jsDependencyFileArray,
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'src/<%= pkg.name %>.js',
                dest: 'build/<%= pkg.name %>.min.js'
            }
        },
        jshint: {
            files: ['Gruntfile.js', 'js/app.js'],
            all: ['js/**/*.js']
        },

        clean: {
            build: {
                src: ['build']
            }
        },

        watch: {
            files: ['js/**/*.js'],
            tasks: ['buildDev'],
            options: {
                nospawn : true
            }
        },
        includereplace: {
            dev: {
                options: {
                    globals: {
                        scriptsTags: '<%= jsScriptTags(jsSrcFileArray, "buildTest")%>'
                    }
                },
                src: [
                    'index.html'
                ],
                dest: '.',
                flatten: true,
                cwd: 'templ',
                expand: true
            },
            prod: {
                options: {
                    globals: {
                        scriptsTags: '<script src="build/frontend-ui.js" type="text/javascript"></script>'
                    }
                },
                src: [
                    'index.html'
                ],
                dest: '.',
                flatten: true,
                cwd: 'templ',
                expand: true
            }
        }
    });

    // Load the plugin that provides the "uglify" task.

    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-include-replace');
    grunt.loadNpmTasks('grunt-contrib-clean');


    // Default task(s).
    grunt.registerTask('default', ['uglify']);



    grunt.registerTask('buildDev', [
        "clean",
        'jshint:all',
        'includereplace:dev'
    ]);

};