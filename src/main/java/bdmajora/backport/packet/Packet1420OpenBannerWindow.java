//package bdmajora.backport.packet;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import net.minecraft.core.net.handler.NetHandler;
//import net.minecraft.core.net.packet.Packet;
//
//public class Packet142OpenBannerWindow extends Packet {
//	public int windowId;
//	public int x;
//	public int y;
//	public int z;
//
//	public Packet142OpenBannerWindow() {
//	}
//
//	public Packet142OpenBannerWindow(int windowId, int x, int y, int z) {
//		this.windowId = windowId;
//		this.x = x;
//		this.y = y;
//		this.z = z;
//	}
//
//	public void readPacketData(DataInputStream dis) throws IOException {
//		this.windowId = dis.readByte();
//		this.x = dis.readInt();
//		this.y = dis.readShort();
//		this.z = dis.readInt();
//	}
//
//	public void writePacketData(DataOutputStream dos) throws IOException {
//		dos.writeByte(this.windowId);
//		dos.writeInt(this.x);
//		dos.writeShort(this.y);
//		dos.writeInt(this.z);
//	}
//
//	public void processPacket(NetHandler netHandler) {
//		netHandler.handleOpenBannerWindow(this);
//	}
//
//	public int getPacketSize() {
//		return 11;
//	}
//}
