package loadFile;

/**
 * Created by huangbaoxian on 2018/3/15.
 */
public class BitCodeBuilder {
    /*
    * 比特币是开源软件，第一个版本是由中本聪编写并将其开源，后来经过核心团队上百次迭代开发，目前最新版本为0.15.0.1，代码托管在github上，项目地址如下，有兴趣的朋友可以访问。

https://github.com/bitcoin/bitcoin

下面从主流的三个操作系统环境给出相应的编译过程。

mac环境

准备工作，首先确保安装好homebrew和xcode，homebrew的下载直接进其官网，地址为https://brew.sh，下载并安装。xcode的安装，先打开bash命令行参数，直接输入命令：

xcode-select --install

下载依赖包，使用homebrew一次性下载所有依赖包，命令如下：

brew install automake berkeley-db4 libtool boost --c++11

miniupnpc openssl pkg-config protobuf python3 qt libevent

如果想打包生成mac版的dmg钱包程序，请执行如下命令，否则跳过此步

brew install librsvg

下载比特币源码并进入根目录，命令如下：

git clone https://github.com/bitcoin/bitcoin

cd bitcoin

执行编译，今次执行如下命令：

./autogen.sh

./configure

make

等待编译完成，这需要花一段时间，如要生成dmg钱包客户端，执行如下命令，否则跳过此步。

make deploy

至此若无报错则成功完成编译，Bitcoin core客户端程序在根目录下，其它如bitcoind、bitcoin-cli、bitcoin-tx等工具在src目录下，以下是小编编译成功后的截图。




unbuntu环境

与mac类似，准备工作同样是安装所需依赖库，命令如下：

sudo apt-get install build-essential libtool autotools-dev autoconf automake libssl-dev libboost-all-dev libdb-dev libdb++-dev pkg-config libevent-devgit-core

生成所需库的配置，命令如下：

生成maek file文件，命令如下：

./configure --without-gui

make编译，命令如下：

maek -j

编译成功后，可执行程序在相应的目录里。

windows环境

window环境最为复杂，需要手动下载非常多的依赖包，期间也可能会遇到各种各样的错误，过程比较繁杂。但是国外有位开发者开源了一系列的bat脚本程序，下载地址：

https://github.com/phelix/easywinbuilder

下载成功后找到__all_easywinbuilder.bat文件，双击按照提示一步步走下去即可。但是有些依赖包在国内无法直接下载，所以尝试失败！

如果您对我的文章感兴趣，也可以关注我或给我评论哦，谢谢！


    * */
}
