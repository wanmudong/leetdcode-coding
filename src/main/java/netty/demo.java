package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.oio.OioDatagramChannel;

import java.net.DatagramPacket;
import java.net.InetSocketAddress;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-10
 */
public class demo {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                        System.out.println("receive data");
                    }
                });
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.manning.com",80));
        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()){
                    System.out.println("connection established");
                }else {
                    System.out.println("connection attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }
    public static void testServerBootstrap(){
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                        System.out.println("receive data");
                    }
                });
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()){
                    System.out.println("connection established");
                }else {
                    System.out.println("connection attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }

    public static void testServerBootstrap02(){
        final ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    ChannelFuture connectFuture;
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        Bootstrap bootstrap1 = new Bootstrap();
                        bootstrap1.channel(NioServerSocketChannel.class)
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                                        System.out.println("received data");
                                    }
                                });
                        bootstrap1.group(ctx.channel().eventLoop());
                        connectFuture = bootstrap1.connect(new InetSocketAddress("www.manning.com",80));
                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                        if (connectFuture.isDone()){
                            //do something with data
                        }
                    }
                });
        bootstrap.option(ChannelOption.SO_KEEPALIVE,true);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000);
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()){
                    System.out.println("service bound");
                }else {
                    System.out.println("bind attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }

    // 在引导过程中添加多个ChannelHandler
    public static void testServerBootstrap03(){
        final ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializerImpl());
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
//        future.sync();
    }

    private static class ChannelInitializerImpl extends ChannelInitializer<Channel> {
        protected void initChannel(Channel channel) throws Exception {
            ChannelPipeline pipeline = channel.pipeline();
        }
    }

    // 面向无连接的协议
    public static void testServerBootstrap04(){
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new OioEventLoopGroup())
                .channel(OioDatagramChannel.class)
                .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {

                    }
                });
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(0));
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()){
                    System.out.println("service bound");
                }else {
                    System.out.println("bind attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }
}
