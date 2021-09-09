let path = require('path');
require('es6-promise').polyfill();

module.exports = {
	mode: 'production',
	entry: ['whatwg-fetch','babel-polyfill','./src/index.js'],
	output: {
		filename:'main.js',
		path: path.resolve(__dirname,'dist'),
		library: 'csvOperations',
		libraryTarget: 'umd',
	},
	module: {
		rules:[
			{
				test: /\.js$/,
				exclude :/(node_modules)/,
				use:{
					loader: 'babel-loader',
					options: {
						presets: [ '@babel/preset-env']
					}
				}
			},{
				test:/\.css$/,
				use:[{loader:'style-loader'},
					{loader:'css-loader'}]
			}
		]
	}
};




///------ babelrc
/*
{
    "presets" : [ "@babel/preset-env"],
    "plugins": [
        [
          "@babel/plugin-proposal-class-properties",
          {
            "loose": true
          }
        ]
      ,
        [
          "transform-remove-console",
          {
            "exclude": [ "error", "warn"] 
          }
        ]
      ]
}


*/
