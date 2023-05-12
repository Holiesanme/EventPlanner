const { shareAll, withModuleFederationPlugin } = require('@angular-architects/module-federation/webpack');

module.exports = withModuleFederationPlugin({

  // remotes: {
  //   mfe1: 'http://localhost:81/remoteEntry.js',
  //   mfe2: 'http://localhost:82/remoteEntry.js'      
  // },

  shared: {
    ...shareAll({ singleton: true, strictVersion: true, requiredVersion: 'auto' }),
  },

});
