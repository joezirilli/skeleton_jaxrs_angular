module.exports = function(grunt) {

  require('load-grunt-tasks')(grunt);
  require('time-grunt')(grunt);

  grunt.initConfig({

    run: {
      clientBuild: {
        exec: ['grunt --gruntfile=./client/Gruntfile.js']
      },
      serverBuild: {
        exec: ['mvn clean install -f ./server/pom.xml'],
      }
    }
  });

  grunt.registerTask('default', [
    'run:clientBuild',
    'run:serverBuild'
  ]);
};
