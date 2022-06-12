package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {
    private String id, nama,jenis_kelamin, alamat, no_identitas, jenis_kamar,hari,tarif,total ;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUD() {
        try {   KoneksiMysql connection = new KoneksiMysql();
                CRUDkoneksi = connection.getkoneksi();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getAlamat() {
        return alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_identitas() {
        return no_identitas;
    }

    public void setNo_identitas(String no_identitas) {
        this.no_identitas = no_identitas;
    }

    public String getJenis_kamar() {
        return jenis_kamar;
    }

    public void setJenis_kamar(String jenis_kamar) {
        this.jenis_kamar = jenis_kamar;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public ResultSet tampilData() 
    { CRUDquery = "select * from hotel";
        try { CRUDstat = CRUDkoneksi.createStatement();
              CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e) {  
        } return CRUDhasil;
    }
    
    public void simpanData(String id, String nama, String alamat,String jenis_kelamin,String no_identitas, String jenis_kamar, String hari, String tarif, String total) 
    { CRUDquery = "insert into hotel values(?,?,?,?,?,?,?,?,?)";
        try {
            
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, alamat);
            CRUDpsmt.setString(4, jenis_kelamin);
            CRUDpsmt.setString(5, no_identitas);
            CRUDpsmt.setString(6, jenis_kamar);
            CRUDpsmt.setString(7, hari);
            CRUDpsmt.setString(8, tarif);
            CRUDpsmt.setString(9, total);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    } 
    
    public void ubahData(String id, String nama, String alamat,String jenis_kelamin,String no_identitas, String jenis_kamar, String hari, String tarif, String total) 
    { CRUDquery = "update hotel set nama=?, alamat=?, jenis_kelamin=?, no_identitas=?, jenis_kamar=?, hari=?, tarif=?, total=? where id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, alamat);
            CRUDpsmt.setString(3, jenis_kelamin);
            CRUDpsmt.setString(4, no_identitas);
            CRUDpsmt.setString(5, jenis_kamar);
            CRUDpsmt.setString(6, hari);
            CRUDpsmt.setString(7, tarif);
            CRUDpsmt.setString(8, total);
            CRUDpsmt.setString(9, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void hapusData(String id) 
    { CRUDquery = "delete from hotel where id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
