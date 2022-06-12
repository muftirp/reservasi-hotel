package crud;

public class Main {
    public static void main(String[] args) {
        try {
            Form_siswa form = new Form_siswa();
            form.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
