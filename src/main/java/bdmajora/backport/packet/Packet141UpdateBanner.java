//package bdmajora.backport.packet;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import net.minecraft.core.net.handler.NetHandler;
//import net.minecraft.core.net.packet.Packet;
//
//public class Packet141UpdateBanner extends Packet {
//	public int x;
//	public int y;
//	public int z;
//	public byte[] bannerColors;
//	public String owner;
//
//	public Packet141UpdateBanner() {
//	}
//
//	public Packet141UpdateBanner(int x, int y, int z, byte[] bannerColors, String owner) {
//		this.x = x;
//		this.y = y;
//		this.z = z;
//		this.bannerColors = bannerColors;
//		this.owner = owner;
//	}
//
//	public void readPacketData(DataInputStream dis) throws IOException {
//		this.x = dis.readInt();
//		this.y = dis.readShort();
//		this.z = dis.readInt();
//		this.bannerColors = new byte[384];
//		dis.readFully(this.bannerColors);
//		this.owner = readString(dis, 16);
//	}
//
//	public void writePacketData(DataOutputStream dos) throws IOException {
//		dos.writeInt(this.x);
//		dos.writeShort(this.y);
//		dos.writeInt(this.z);
//		dos.write(this.bannerColors);
//		writeString(this.owner, dos);
//	}
//
//	public void processPacket(NetHandler netHandler) {
//		netHandler.handleUpdateBanner(this);
//	}
//
//	public int getPacketSize() {
//		return 0;
//	}
//}
//
