module.exports = {
    outputDir: 'target/dist',
    assetsDir: 'static',
    publicPath: './',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8088',
                ws: true,
                changeOrigin: true
            }
        }
    }
};