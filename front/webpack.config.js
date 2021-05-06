const path = require('path');
const HtmlWebPackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CssMinimizerPlugin = require('css-minimizer-webpack-plugin');
const webpack = require('webpack');

module.exports = (env, argv) => {
  const mode = argv.mode || 'production';
  return {
    entry: './src/index.js',
    plugins: [
      new HtmlWebPackPlugin({
        title: 'Lift: Career-solution',
        hash: true,
        template: './public/index.html',
      }),
      new webpack.HotModuleReplacementPlugin(),
      new CleanWebpackPlugin(),
      new MiniCssExtractPlugin(),
      new CssMinimizerPlugin(),
      new webpack.HotModuleReplacementPlugin(),
    ],
    output: {
      path: path.resolve(__dirname, './dist'),
      pathinfo: true,
      filename: '[name].js',
    },
    devServer: {
      historyApiFallback: true,
    },
    resolve: {
      alias: {
        src: path.resolve(__dirname, './src'),
      },
    },
    module: {
      rules: [
        {
          test: /\.m?js$/,
          exclude: /(node_modules|bower_components)/,
          use: {
            loader: 'babel-loader',
            options: {
              presets: ['@babel/preset-env'],
            }
          }
        },
        {
          test: /\.(png|jpe?g|gif)$/i,
          type: 'asset/resource'
        },
        {
          test: /\.css$/,
          use: [
            mode === 'development' ? 'style-loader' : MiniCssExtractPlugin.loader,
            'css-loader'
          ]
        },
        {
          test: /\.s[ac]ss$/i,
          use: [
            mode === 'development' ? 'style-loader' : MiniCssExtractPlugin.loader,
            {
              loader: "css-loader",
              options: {
                modules: true,
                importLoaders: 1,
              },
            },
            "sass-loader",
          ],
        },
      ]
    },
  };
};
