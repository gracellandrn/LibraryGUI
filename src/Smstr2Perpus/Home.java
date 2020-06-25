/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Smstr2Perpus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    DefaultTableModel gra, cel, la, ni;
    boolean a = true;
    
    public Home() {
        initComponents();

        //jtable create
        gra = (DefaultTableModel) tabelBuku.getModel();
        cel = (DefaultTableModel) tabelMember.getModel();
        la = (DefaultTableModel) tabelPinjam.getModel();
        ni = (DefaultTableModel) tabelPengembalian.getModel();
    }

    //ADD ROWS BOOKS
    private void rowBook(String kode, String judul, String pengarang, String penerbit, String thnTerbit, String kategori, String rakBuku, String posisi) {
        String[] rowDataBooks = {kode, judul, pengarang, penerbit, thnTerbit, kategori, rakBuku, posisi};
        gra.addRow(rowDataBooks);
    }

    //ADD ROWS MEMBER
    private void rowMember(String id, String nama, String gender, String alamat, String tanggal, String noHp) {
        String[] rowDataMember = {id, nama, gender, alamat, tanggal, noHp};
        cel.addRow(rowDataMember);
    }

    //ADD ROWS Pinjam
    private void rowPinjam(String idMember, String nama, String kode, String date, String expdate) {
        String[] rowDataPinjam = {idMember, nama, kode, date, expdate};
        la.addRow(rowDataPinjam);
    }

    //ADD ROWS Kembali
    private void rowKembali(String idBuku, String idMember, String memberName, String pinjamDate, String ExpDate, String kembaliDate, String telat, String denda) {
        String[] rowDataKembali = {idBuku, idMember, memberName, pinjamDate, ExpDate, kembaliDate, telat, denda};
        ni.addRow(rowDataKembali);
    }

    //ADD RADIO BUTTON GENDER MEMBER
    String genderMethod() {
        String gender = "";
        if (radioBtnLaki.isSelected()) {
            gender = radioBtnLaki.getText();
        } else {
            gender = radioBtnPerempuan.getText();
        }
        return gender;
    }

    //HIDE MENU
    public void hideshow(JPanel menushowhide, boolean dashboard, JLabel button) {
        if (dashboard == true) {
            menushowhide.setPreferredSize(new Dimension(70, 611));
            changeImage(button, "icons8-menu-40.png");
        } else {
            menushowhide.setPreferredSize(new Dimension(138, 611));
            changeImage(button, "icons8-back-40.png");
        }
    }

    //CHANGE IMAGE MENU
    public void changeImage(JLabel button, String resourcheimg) {
        ImageIcon aimg = new ImageIcon(getClass().getResource(resourcheimg));
        button.setIcon(aimg);
    }

    //CHANGE COLOR MENU
    public void clickmenu(JPanel h1, JPanel h2, JPanel h3, JPanel h4, JPanel h5, int number) {
        if (number == 1) {
            h1.setBackground(new Color(153, 0, 153));
            h2.setBackground(new Color(240, 205, 231));
            h3.setBackground(new Color(240, 205, 231));
            h4.setBackground(new Color(240, 205, 231));
            h5.setBackground(new Color(240, 205, 231));
        }
    }

    int searchIDMember(JTable e, String x, int i, int j) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (x.equals(tabelMember.getValueAt(mid, 0))) {
                labelNama.setText(tabelMember.getValueAt(mid, 1).toString());
                return 1;
            } else if (x.compareTo((String) tabelMember.getValueAt(mid, 0)) < 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    int searchKDBuku(JTable e, String x, int i, int j) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (x.equals(tabelBuku.getValueAt(mid, 0))) {
                labelJudul.setText(tabelBuku.getValueAt(mid, 1).toString());
                return 1;
            } else if (x.compareTo((String) tabelBuku.getValueAt(mid, 0)) < 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGender = new javax.swing.ButtonGroup();
        bodyPanel = new javax.swing.JPanel();
        slidebarPanel = new javax.swing.JPanel();
        hidePanel = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        iconPanel = new javax.swing.JPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        sembunyi = new javax.swing.JPanel();
        labelHide = new javax.swing.JLabel();
        menuHome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menuBooks = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        menuMember = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        menuPinjam = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        menuKembali = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        buttonLogOut = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jumlahPeminjaman = new javax.swing.JButton();
        jumlahPengembalian = new javax.swing.JButton();
        labelJumlahPinjam = new javax.swing.JLabel();
        labelJumlahKembali = new javax.swing.JLabel();
        labelJumlahMember = new javax.swing.JLabel();
        labelJumlahBuku = new javax.swing.JLabel();
        jumlahBuku = new javax.swing.JButton();
        jumlahMember = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        memberPanel = new javax.swing.JPanel();
        idMemberTxt = new javax.swing.JTextField();
        radioBtnLaki = new javax.swing.JRadioButton();
        radioBtnPerempuan = new javax.swing.JRadioButton();
        alamatTxt = new javax.swing.JTextField();
        noHpTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();
        dateLahirMember = new com.toedter.calendar.JDateChooser();
        namaTxt = new javax.swing.JTextField();
        filterMember = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        buttonAddMember = new javax.swing.JButton();
        buttonEditMember = new javax.swing.JButton();
        buttonDeleteMember = new javax.swing.JButton();
        exportMember = new javax.swing.JButton();
        importMember = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pengembalianPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cariBuku = new javax.swing.JTextField();
        cariPinjamBtn = new javax.swing.JButton();
        labelPinjamID = new javax.swing.JLabel();
        labelPinjamName = new javax.swing.JLabel();
        labelTanggalPinjam = new javax.swing.JLabel();
        labelBatasKembali = new javax.swing.JLabel();
        kembaliDate = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        labelTelat = new javax.swing.JLabel();
        labelDenda = new javax.swing.JLabel();
        addReturn = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelPengembalian = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        filterKembali = new javax.swing.JTextField();
        kembaliExport = new javax.swing.JButton();
        kembaliImport = new javax.swing.JButton();
        kembaliDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        peminjamanPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelPinjam = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        filterMinjam = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cariID = new javax.swing.JTextField();
        cariIDbtn = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cariKode = new javax.swing.JTextField();
        cariKodeBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        labelJudul = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pinjamDate = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        pinjamExp = new com.toedter.calendar.JDateChooser();
        pinjamAdd = new javax.swing.JButton();
        pinjamDelete = new javax.swing.JButton();
        pinjamExport = new javax.swing.JButton();
        pinjamImport = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bookPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        filterBuku = new javax.swing.JTextField();
        kodeBukuTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        judulBukuTxt = new javax.swing.JTextField();
        pengarangTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        penerbitTxt = new javax.swing.JTextField();
        kategoriBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        posisi = new javax.swing.JTextField();
        addKategoriTxt = new javax.swing.JTextField();
        rakBuku = new javax.swing.JTextField();
        addKategori = new javax.swing.JButton();
        deleteKategori = new javax.swing.JButton();
        thnTerbit = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        importBookBtn = new javax.swing.JButton();
        exportBookBtn = new javax.swing.JButton();
        buttonDeleteBooks = new javax.swing.JButton();
        buttonEditBooks = new javax.swing.JButton();
        buttonAddBooks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perpustakaan");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1120, 650));
        setSize(new java.awt.Dimension(1350, 816));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bodyPanel.setPreferredSize(new java.awt.Dimension(1000, 600));

        slidebarPanel.setPreferredSize(new java.awt.Dimension(135, 611));
        slidebarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hidePanel.setPreferredSize(new java.awt.Dimension(71, 611));

        kGradientPanel4.setkEndColor(new java.awt.Color(0, 0, 102));
        kGradientPanel4.setkStartColor(new java.awt.Color(153, 0, 153));

        jLabel49.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("hide");

        jLabel45.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("books");

        jLabel44.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("member");

        jLabel47.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Borrow");

        jLabel46.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("return");

        jLabel43.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Home");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel49)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel43)
                    .addComponent(jLabel47))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addGap(65, 65, 65)
                .addComponent(jLabel43)
                .addGap(51, 51, 51)
                .addComponent(jLabel45)
                .addGap(45, 45, 45)
                .addComponent(jLabel44)
                .addGap(52, 52, 52)
                .addComponent(jLabel47)
                .addGap(48, 48, 48)
                .addComponent(jLabel46)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout hidePanelLayout = new javax.swing.GroupLayout(hidePanel);
        hidePanel.setLayout(hidePanelLayout);
        hidePanelLayout.setHorizontalGroup(
            hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        hidePanelLayout.setVerticalGroup(
            hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hidePanelLayout.createSequentialGroup()
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        slidebarPanel.add(hidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 70, 611));

        iconPanel.setPreferredSize(new java.awt.Dimension(611, 67));
        iconPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel5.setkEndColor(new java.awt.Color(0, 0, 102));
        kGradientPanel5.setkStartColor(new java.awt.Color(153, 0, 153));
        kGradientPanel5.setPreferredSize(new java.awt.Dimension(148, 773));

        sembunyi.setBackground(new java.awt.Color(240, 205, 231));
        sembunyi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sembunyiMouseClicked(evt);
            }
        });
        sembunyi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-back-40.png"))); // NOI18N
        sembunyi.add(labelHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        menuHome.setBackground(new java.awt.Color(240, 205, 231));
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHomeMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-home-page-40 (1).png"))); // NOI18N

        javax.swing.GroupLayout menuHomeLayout = new javax.swing.GroupLayout(menuHome);
        menuHome.setLayout(menuHomeLayout);
        menuHomeLayout.setHorizontalGroup(
            menuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuHomeLayout.setVerticalGroup(
            menuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        menuBooks.setBackground(new java.awt.Color(240, 205, 231));
        menuBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBooksMouseClicked(evt);
            }
        });

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-books-40.png"))); // NOI18N

        javax.swing.GroupLayout menuBooksLayout = new javax.swing.GroupLayout(menuBooks);
        menuBooks.setLayout(menuBooksLayout);
        menuBooksLayout.setHorizontalGroup(
            menuBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuBooksLayout.setVerticalGroup(
            menuBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        menuMember.setBackground(new java.awt.Color(240, 205, 231));
        menuMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMemberMouseClicked(evt);
            }
        });

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-crowd-40.png"))); // NOI18N

        javax.swing.GroupLayout menuMemberLayout = new javax.swing.GroupLayout(menuMember);
        menuMember.setLayout(menuMemberLayout);
        menuMemberLayout.setHorizontalGroup(
            menuMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuMemberLayout.setVerticalGroup(
            menuMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        menuPinjam.setBackground(new java.awt.Color(240, 205, 231));
        menuPinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPinjamMouseClicked(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-reading-40.png"))); // NOI18N

        javax.swing.GroupLayout menuPinjamLayout = new javax.swing.GroupLayout(menuPinjam);
        menuPinjam.setLayout(menuPinjamLayout);
        menuPinjamLayout.setHorizontalGroup(
            menuPinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPinjamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPinjamLayout.setVerticalGroup(
            menuPinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
        );

        menuKembali.setBackground(new java.awt.Color(240, 205, 231));
        menuKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuKembaliMouseClicked(evt);
            }
        });

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-book-shelf-40.png"))); // NOI18N

        javax.swing.GroupLayout menuKembaliLayout = new javax.swing.GroupLayout(menuKembali);
        menuKembali.setLayout(menuKembaliLayout);
        menuKembaliLayout.setHorizontalGroup(
            menuKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuKembaliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuKembaliLayout.setVerticalGroup(
            menuKembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sembunyi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addComponent(sembunyi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(menuHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(menuBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(menuMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(menuPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(menuKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 293, Short.MAX_VALUE))
        );

        iconPanel.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 664));

        slidebarPanel.add(iconPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 611));

        headerPanel.setBackground(new java.awt.Color(153, 204, 255));
        headerPanel.setPreferredSize(new java.awt.Dimension(1130, 39));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 102));
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 0, 153));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(1100, 39));

        buttonLogOut.setFont(new java.awt.Font("Felix Titling", 1, 10)); // NOI18N
        buttonLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-delete-50.png"))); // NOI18N
        buttonLogOut.setMargin(new java.awt.Insets(2, 0, 2, 0));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(1069, Short.MAX_VALUE)
                .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.setBackground(new java.awt.Color(153, 153, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jumlahPeminjaman.setBackground(new java.awt.Color(204, 204, 255));
        jumlahPeminjaman.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jumlahPeminjaman.setText("Jumlah Peminjaman");
        jumlahPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahPeminjamanActionPerformed(evt);
            }
        });
        homePanel.add(jumlahPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 210, 40));

        jumlahPengembalian.setBackground(new java.awt.Color(204, 204, 255));
        jumlahPengembalian.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jumlahPengembalian.setText("Jumlah Pengembalian");
        jumlahPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahPengembalianActionPerformed(evt);
            }
        });
        homePanel.add(jumlahPengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 210, 40));

        labelJumlahPinjam.setFont(new java.awt.Font("Wide Latin", 0, 36)); // NOI18N
        labelJumlahPinjam.setForeground(new java.awt.Color(214, 125, 179));
        homePanel.add(labelJumlahPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 83, 90));

        labelJumlahKembali.setFont(new java.awt.Font("Wide Latin", 0, 36)); // NOI18N
        labelJumlahKembali.setForeground(new java.awt.Color(214, 125, 179));
        homePanel.add(labelJumlahKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 60, 80));

        labelJumlahMember.setFont(new java.awt.Font("Wide Latin", 0, 36)); // NOI18N
        labelJumlahMember.setForeground(new java.awt.Color(214, 125, 179));
        homePanel.add(labelJumlahMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 81, 90));

        labelJumlahBuku.setFont(new java.awt.Font("Wide Latin", 0, 36)); // NOI18N
        labelJumlahBuku.setForeground(new java.awt.Color(214, 125, 179));
        homePanel.add(labelJumlahBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 81, 90));

        jumlahBuku.setBackground(new java.awt.Color(204, 204, 255));
        jumlahBuku.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jumlahBuku.setText("Jumlah Buku");
        jumlahBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBukuActionPerformed(evt);
            }
        });
        homePanel.add(jumlahBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 210, 40));

        jumlahMember.setBackground(new java.awt.Color(204, 204, 255));
        jumlahMember.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jumlahMember.setText("Jumlah Member");
        jumlahMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahMemberActionPerformed(evt);
            }
        });
        homePanel.add(jumlahMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, 210, 40));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/kotak.gif"))); // NOI18N
        homePanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 240, 200));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/kotak.gif"))); // NOI18N
        homePanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 230, 220));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/kotak.gif"))); // NOI18N
        homePanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 230, 240));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/kotak.gif"))); // NOI18N
        homePanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 260, 210));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/home3.gif"))); // NOI18N
        homePanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 1350, -1));

        mainPanel.add(homePanel, "card2");

        memberPanel.setBackground(new java.awt.Color(255, 255, 255));
        memberPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idMemberTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        memberPanel.add(idMemberTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 166, -1));

        btnGender.add(radioBtnLaki);
        radioBtnLaki.setText("Laki-laki");
        memberPanel.add(radioBtnLaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        btnGender.add(radioBtnPerempuan);
        radioBtnPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnPerempuan.setText("Perempuan");
        memberPanel.add(radioBtnPerempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        alamatTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        memberPanel.add(alamatTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 160, 40));

        noHpTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        memberPanel.add(noHpTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 166, -1));

        jLabel13.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel13.setText("Id Member");
        memberPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 180, 90, -1));

        jLabel14.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel14.setText("Nama Lengkap");
        memberPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel15.setText("Gender");
        memberPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel16.setText("Alamat");
        memberPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 316, -1, 20));

        jLabel17.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel17.setText("Tanggal Lahir");
        memberPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, 26));

        jLabel18.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel18.setText("No Hp");
        memberPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, 20));

        tabelMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Member", "Nama", "Gender", "Alamat", "Tanggal Lahir", "No Hp"
            }
        ));
        tabelMember.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMemberMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelMember);
        if (tabelMember.getColumnModel().getColumnCount() > 0) {
            tabelMember.getColumnModel().getColumn(4).setHeaderValue("Tanggal Lahir");
            tabelMember.getColumnModel().getColumn(5).setHeaderValue("No Hp");
        }

        memberPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 540, 280));
        memberPanel.add(dateLahirMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 166, -1));

        namaTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        memberPanel.add(namaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 166, -1));

        filterMember.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        filterMember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterMemberKeyReleased(evt);
            }
        });
        memberPanel.add(filterMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 254, -1));

        jLabel53.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Search Data");
        memberPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        buttonAddMember.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        buttonAddMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-add-30.png"))); // NOI18N
        buttonAddMember.setText("Add");
        buttonAddMember.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddMemberActionPerformed(evt);
            }
        });
        memberPanel.add(buttonAddMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 90, 30));

        buttonEditMember.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        buttonEditMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-edit-30.png"))); // NOI18N
        buttonEditMember.setText("Edit");
        buttonEditMember.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonEditMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditMemberActionPerformed(evt);
            }
        });
        memberPanel.add(buttonEditMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 100, 30));

        buttonDeleteMember.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        buttonDeleteMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-trash-30.png"))); // NOI18N
        buttonDeleteMember.setText("Delete");
        buttonDeleteMember.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonDeleteMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteMemberActionPerformed(evt);
            }
        });
        memberPanel.add(buttonDeleteMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 110, 30));

        exportMember.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        exportMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-save-30.png"))); // NOI18N
        exportMember.setText("Save");
        exportMember.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exportMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMemberActionPerformed(evt);
            }
        });
        memberPanel.add(exportMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 100, 30));

        importMember.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        importMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-view-30.png"))); // NOI18N
        importMember.setText("View");
        importMember.setMargin(new java.awt.Insets(0, 0, 0, 0));
        importMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMemberActionPerformed(evt);
            }
        });
        memberPanel.add(importMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 100, 30));

        jLabel4.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/member.gif"))); // NOI18N
        jLabel4.setText("Data Member");
        memberPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 640));

        mainPanel.add(memberPanel, "card4");

        pengembalianPanel.setBackground(new java.awt.Color(255, 255, 255));
        pengembalianPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tanggal Pengembalian");
        pengembalianPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        jLabel27.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel27.setText("Kode Book");
        pengembalianPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel28.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel28.setText("Member Name");
        pengembalianPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel29.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel29.setText("Tanggal Pinjam");
        pengembalianPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel30.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Deadline Pengembalian");
        pengembalianPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jLabel37.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Keterlambatan Hari");
        pengembalianPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        jLabel31.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Denda");
        pengembalianPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        cariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBukuActionPerformed(evt);
            }
        });
        pengembalianPanel.add(cariBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 110, -1));

        cariPinjamBtn.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        cariPinjamBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-search-30.png"))); // NOI18N
        cariPinjamBtn.setText("Search");
        cariPinjamBtn.setMargin(new java.awt.Insets(0, 2, 2, 2));
        cariPinjamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPinjamBtnActionPerformed(evt);
            }
        });
        pengembalianPanel.add(cariPinjamBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 30));

        labelPinjamID.setFont(new java.awt.Font("SimSun", 0, 16)); // NOI18N
        pengembalianPanel.add(labelPinjamID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 96, 35));

        labelPinjamName.setFont(new java.awt.Font("SimSun", 0, 16)); // NOI18N
        pengembalianPanel.add(labelPinjamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 144, 29));

        labelTanggalPinjam.setFont(new java.awt.Font("SimSun", 0, 16)); // NOI18N
        pengembalianPanel.add(labelTanggalPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 144, 29));

        labelBatasKembali.setFont(new java.awt.Font("SimSun", 0, 16)); // NOI18N
        labelBatasKembali.setForeground(new java.awt.Color(255, 255, 255));
        pengembalianPanel.add(labelBatasKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 144, 30));
        pengembalianPanel.add(kembaliDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 130, 30));

        jButton3.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-estimate-30.png"))); // NOI18N
        jButton3.setText("Hitung");
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pengembalianPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 110, 30));

        labelTelat.setFont(new java.awt.Font("SimSun", 0, 16)); // NOI18N
        labelTelat.setForeground(new java.awt.Color(255, 255, 255));
        pengembalianPanel.add(labelTelat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 120, 33));

        labelDenda.setFont(new java.awt.Font("SimSun", 0, 16)); // NOI18N
        labelDenda.setForeground(new java.awt.Color(255, 255, 255));
        pengembalianPanel.add(labelDenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 144, 30));

        addReturn.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        addReturn.setText("Return Book");
        addReturn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReturnActionPerformed(evt);
            }
        });
        pengembalianPanel.add(addReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 120, 30));

        jLabel35.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel35.setText("ID Member");
        pengembalianPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        tabelPengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Buku", "ID Member", "Name", "Peminjaman", "Deadline", "Pengembalian", "Keterlambatan", "Denda"
            }
        ));
        jScrollPane4.setViewportView(tabelPengembalian);

        pengembalianPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 680, 190));

        jLabel55.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Search Data");
        pengembalianPanel.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        filterKembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterKembaliKeyReleased(evt);
            }
        });
        pengembalianPanel.add(filterKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 300, -1));

        kembaliExport.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        kembaliExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-save-30.png"))); // NOI18N
        kembaliExport.setText("Save");
        kembaliExport.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kembaliExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliExportActionPerformed(evt);
            }
        });
        pengembalianPanel.add(kembaliExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 120, -1));

        kembaliImport.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        kembaliImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-view-30.png"))); // NOI18N
        kembaliImport.setText("View");
        kembaliImport.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kembaliImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliImportActionPerformed(evt);
            }
        });
        pengembalianPanel.add(kembaliImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, 120, -1));

        kembaliDelete.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        kembaliDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-trash-30.png"))); // NOI18N
        kembaliDelete.setText("Delete");
        kembaliDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kembaliDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliDeleteActionPerformed(evt);
            }
        });
        pengembalianPanel.add(kembaliDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 450, 120, -1));

        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/kembali.gif"))); // NOI18N
        pengembalianPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1340, 570));

        mainPanel.add(pengembalianPanel, "card6");

        peminjamanPanel.setBackground(new java.awt.Color(255, 255, 255));
        peminjamanPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelPinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Member", "Nama", "Kode Buku", "Peminjaman", "Deadline"
            }
        ));
        jScrollPane3.setViewportView(tabelPinjam);

        peminjamanPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 430, 360));

        jLabel54.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Search Data");
        peminjamanPanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        filterMinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterMinjamActionPerformed(evt);
            }
        });
        filterMinjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterMinjamKeyReleased(evt);
            }
        });
        peminjamanPanel.add(filterMinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 254, -1));

        jLabel20.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel20.setText("ID Member");
        peminjamanPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 137, -1));
        peminjamanPanel.add(cariID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 130, 30));

        cariIDbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-search-30.png"))); // NOI18N
        cariIDbtn.setText("Search");
        cariIDbtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cariIDbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariIDbtnActionPerformed(evt);
            }
        });
        peminjamanPanel.add(cariIDbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 100, 30));

        jLabel21.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel21.setText("Nama");
        peminjamanPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 79, -1));

        labelNama.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("---");
        peminjamanPanel.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 180, 20));

        jLabel22.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel22.setText("Kode Buku");
        peminjamanPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));
        peminjamanPanel.add(cariKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 130, 30));

        cariKodeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-search-30.png"))); // NOI18N
        cariKodeBtn.setText("Search");
        cariKodeBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cariKodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariKodeBtnActionPerformed(evt);
            }
        });
        peminjamanPanel.add(cariKodeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 100, 30));

        jLabel23.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel23.setText("Judul Buku");
        peminjamanPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        labelJudul.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(255, 255, 255));
        labelJudul.setText("---");
        peminjamanPanel.add(labelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 190, 30));

        jLabel24.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel24.setText("Tanggal Peminjaman");
        peminjamanPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));
        peminjamanPanel.add(pinjamDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 140, 30));

        jLabel25.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel25.setText("Deadline Pengembalian");
        peminjamanPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));
        peminjamanPanel.add(pinjamExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 140, 30));

        pinjamAdd.setFont(new java.awt.Font("SimSun-ExtB", 0, 14)); // NOI18N
        pinjamAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-add-30.png"))); // NOI18N
        pinjamAdd.setText("Add");
        pinjamAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pinjamAdd.setPreferredSize(new java.awt.Dimension(90, 40));
        pinjamAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamAddActionPerformed(evt);
            }
        });
        peminjamanPanel.add(pinjamAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 100, 30));

        pinjamDelete.setFont(new java.awt.Font("SimSun-ExtB", 0, 14)); // NOI18N
        pinjamDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-trash-30.png"))); // NOI18N
        pinjamDelete.setText("Delete");
        pinjamDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pinjamDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamDeleteActionPerformed(evt);
            }
        });
        peminjamanPanel.add(pinjamDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, 30));

        pinjamExport.setFont(new java.awt.Font("SimSun-ExtB", 0, 14)); // NOI18N
        pinjamExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-save-30.png"))); // NOI18N
        pinjamExport.setText("Save");
        pinjamExport.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pinjamExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamExportActionPerformed(evt);
            }
        });
        peminjamanPanel.add(pinjamExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 100, 30));

        pinjamImport.setFont(new java.awt.Font("SimSun-ExtB", 0, 14)); // NOI18N
        pinjamImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-view-30.png"))); // NOI18N
        pinjamImport.setText("View");
        pinjamImport.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pinjamImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamImportActionPerformed(evt);
            }
        });
        peminjamanPanel.add(pinjamImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 110, 30));

        jLabel5.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/pinjam.gif"))); // NOI18N
        peminjamanPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, -1));

        mainPanel.add(peminjamanPanel, "card5");

        bookPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Buku", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Kategori", "Rak Buku", "Posisi"
            }
        ));
        tabelBuku.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBuku);

        bookPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 118, 580, 400));

        jLabel52.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Search Data");
        bookPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 76, -1, -1));

        filterBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBukuActionPerformed(evt);
            }
        });
        filterBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterBukuKeyReleased(evt);
            }
        });
        bookPanel.add(filterBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 74, 254, -1));

        kodeBukuTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(kodeBukuTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 203, -1));

        jLabel10.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Penerbit");
        bookPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        judulBukuTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(judulBukuTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 203, -1));

        pengarangTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(pengarangTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 203, -1));

        jLabel7.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode Buku");
        bookPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        penerbitTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(penerbitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 203, -1));

        kategoriBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kategoriBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comedy", "Biography", "Science Fictions", "Academy" }));
        bookPanel.add(kategoriBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 203, -1));

        jLabel12.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Kategori");
        bookPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel11.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tahun Terbit");
        bookPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pengarang");
        bookPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Judul Buku");
        bookPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel19.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Rak Buku");
        bookPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, 20));

        jLabel34.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Posisi");
        bookPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, 20));

        posisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(posisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 130, -1));

        addKategoriTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(addKategoriTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 100, -1));

        rakBuku.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookPanel.add(rakBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 130, -1));

        addKategori.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        addKategori.setText("Add Kategori");
        addKategori.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKategoriActionPerformed(evt);
            }
        });
        bookPanel.add(addKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, -1));

        deleteKategori.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        deleteKategori.setText("Delete Kategori");
        deleteKategori.setMargin(new java.awt.Insets(0, 0, 0, 0));
        deleteKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteKategoriActionPerformed(evt);
            }
        });
        bookPanel.add(deleteKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 120, -1));
        bookPanel.add(thnTerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/kotakbuku6.gif"))); // NOI18N
        bookPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 470));

        jLabel3.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/buku2.gif"))); // NOI18N
        bookPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 520));

        importBookBtn.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        importBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-view-30.png"))); // NOI18N
        importBookBtn.setText("View");
        importBookBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        importBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBookBtnActionPerformed(evt);
            }
        });
        bookPanel.add(importBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 92, -1));

        exportBookBtn.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        exportBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-save-30.png"))); // NOI18N
        exportBookBtn.setText("Save");
        exportBookBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exportBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBookBtnActionPerformed(evt);
            }
        });
        bookPanel.add(exportBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 100, -1));

        buttonDeleteBooks.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        buttonDeleteBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-trash-30.png"))); // NOI18N
        buttonDeleteBooks.setText("Delete");
        buttonDeleteBooks.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonDeleteBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteBooksActionPerformed(evt);
            }
        });
        bookPanel.add(buttonDeleteBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 110, -1));

        buttonEditBooks.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        buttonEditBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-edit-30.png"))); // NOI18N
        buttonEditBooks.setText("Edit");
        buttonEditBooks.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonEditBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditBooksActionPerformed(evt);
            }
        });
        bookPanel.add(buttonEditBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 100, -1));

        buttonAddBooks.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        buttonAddBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smstr2Perpus/icons8-add-30.png"))); // NOI18N
        buttonAddBooks.setText("Add");
        buttonAddBooks.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonAddBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddBooksActionPerformed(evt);
            }
        });
        bookPanel.add(buttonAddBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 100, -1));

        mainPanel.add(bookPanel, "card3");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(slidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1381, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 816));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        JOptionPane.showMessageDialog(this, "Harap Menyimpan Semua Data Sebelum Keluar", "Information", JOptionPane.WARNING_MESSAGE);
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int buttonResult = JOptionPane.showConfirmDialog(this, "Anda yakin ingin keluar?", "Peringatan", buttonDialog);

        if (buttonResult == 0) {
            //true
            System.exit(0);
        } //false
        else {
        }
    }//GEN-LAST:event_buttonLogOutActionPerformed

    private void buttonAddBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddBooksActionPerformed
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy");
        String date = dformat.format(thnTerbit.getYear());

        int jumlahBaris = tabelBuku.getRowCount();
        boolean belumAda = true;
        for (int i = 0; i < jumlahBaris; i++) {
            if (kodeBukuTxt.getText().equals(tabelBuku.getValueAt(i, 0))) {
                belumAda = false;
                break;
            }
        }

        if (kodeBukuTxt.getText().isEmpty() | judulBukuTxt.getText().isEmpty() | pengarangTxt.getText().isEmpty() | penerbitTxt.getText().isEmpty() | date.isEmpty() | kategoriBox.getSelectedItem().toString().isEmpty() | rakBuku.getText().isEmpty() | posisi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data buku tidak boleh kosong");
        }else if(belumAda){
            rowBook(kodeBukuTxt.getText(), judulBukuTxt.getText(), pengarangTxt.getText(), penerbitTxt.getText(), String.valueOf(thnTerbit.getYear()), kategoriBox.getSelectedItem().toString(), rakBuku.getText(), posisi.getText());
            //CLEAR TXT
            kodeBukuTxt.setText("");
            judulBukuTxt.setText("");
            pengarangTxt.setText("");
            penerbitTxt.setText("");
            rakBuku.setText("");
            posisi.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Kode buku sudah ada");
        }


    }//GEN-LAST:event_buttonAddBooksActionPerformed

    //SET SELECTIONS TO TEXTFIELDS
    private void tabelBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBukuMouseClicked
        // TODO add your handling code here:
        try {
            kodeBukuTxt.setText(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 0).toString());
            judulBukuTxt.setText(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 1).toString());
            pengarangTxt.setText(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 2).toString());
            penerbitTxt.setText(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 3).toString());
            thnTerbit.setYear((int) tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 4));
            kategoriBox.setSelectedItem(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 5).toString());
            rakBuku.setText(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 6).toString());
            posisi.setText(tabelBuku.getValueAt(tabelBuku.getSelectedRow(), 7).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tabelBukuMouseClicked

    //REMOVE ROW
    private void buttonDeleteBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteBooksActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            try {
                gra.removeRow(tabelBuku.getSelectedRow());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
            }
            //CLEAR TXT
            kodeBukuTxt.setText("");
            judulBukuTxt.setText("");
            pengarangTxt.setText("");
            penerbitTxt.setText("");
            thnTerbit.setYear(2020);
            rakBuku.setText("");
            posisi.setText("");
        } else {
        }
    }//GEN-LAST:event_buttonDeleteBooksActionPerformed

    //EDIT DATA
    private void buttonEditBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditBooksActionPerformed
        gra.setValueAt(kodeBukuTxt.getText(), tabelBuku.getSelectedRow(), 0);
        gra.setValueAt(judulBukuTxt.getText(), tabelBuku.getSelectedRow(), 1);
        gra.setValueAt(pengarangTxt.getText(), tabelBuku.getSelectedRow(), 2);
        gra.setValueAt(penerbitTxt.getText(), tabelBuku.getSelectedRow(), 3);
        gra.setValueAt(thnTerbit.getYear(), tabelBuku.getSelectedRow(), 4);
        gra.setValueAt(kategoriBox.getSelectedItem(), tabelBuku.getSelectedRow(), 5);
        gra.setValueAt(rakBuku.getText(),tabelBuku.getSelectedRow(), 6);
        gra.setValueAt(posisi.getText(), tabelBuku.getSelectedRow(), 7);

        //CLEAR TXT
        kodeBukuTxt.setText("");
        judulBukuTxt.setText("");
        pengarangTxt.setText("");
        penerbitTxt.setText("");
        thnTerbit.setYear(2020);
        rakBuku.setText("");
        posisi.setText("");
    }//GEN-LAST:event_buttonEditBooksActionPerformed

    private void buttonAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddMemberActionPerformed
        try {
            SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
            String date = dformat.format(dateLahirMember.getDate());
            boolean belumAda = true;
            int jumlahBaris = tabelMember.getRowCount();

            for (int i = 0; i < jumlahBaris; i++) {
                if (idMemberTxt.getText().equals(tabelMember.getValueAt(i, 0))) {
                    belumAda = false;
                    break;
                }
            }
            if (idMemberTxt.getText().isEmpty() | namaTxt.getText().isEmpty() | genderMethod().isEmpty() | alamatTxt.getText().isEmpty() | noHpTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data member tidak boleh kosong");
            } else if (belumAda) {
                rowMember(idMemberTxt.getText(), namaTxt.getText(), genderMethod(), alamatTxt.getText(), date, noHpTxt.getText());
                //CLEAR TXT
                idMemberTxt.setText("");
                namaTxt.setText("");
                alamatTxt.setText("");
                dateLahirMember.setDate(null);
                noHpTxt.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "ID member sudah ada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong");
        }
    }//GEN-LAST:event_buttonAddMemberActionPerformed

    private void buttonEditMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditMemberActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dformat.format(dateLahirMember.getDate());

        cel.setValueAt(idMemberTxt.getText(), tabelMember.getSelectedRow(), 0);
        cel.setValueAt(namaTxt.getText(), tabelMember.getSelectedRow(), 1);
        cel.setValueAt(genderMethod(), tabelMember.getSelectedRow(), 2);
        cel.setValueAt(alamatTxt.getText(), tabelMember.getSelectedRow(), 3);
        cel.setValueAt(date, tabelMember.getSelectedRow(), 4);
        cel.setValueAt(noHpTxt.getText(), tabelMember.getSelectedRow(), 5);

        //CLEAR TXT
        idMemberTxt.setText("");
        namaTxt.setText("");
        alamatTxt.setText("");
        dateLahirMember.setDate(null);
        noHpTxt.setText("");
    }//GEN-LAST:event_buttonEditMemberActionPerformed

    private void tabelMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMemberMouseClicked
        idMemberTxt.setText(tabelMember.getValueAt(tabelMember.getSelectedRow(), 0).toString());
        namaTxt.setText(tabelMember.getValueAt(tabelMember.getSelectedRow(), 1).toString());
        String gender = (tabelMember.getValueAt(tabelMember.getSelectedRow(), 2).toString());
        if (gender.equals("Laki-laki")) {
            radioBtnLaki.setSelected(true);
        } else {
            radioBtnPerempuan.setSelected(true);
        }
        alamatTxt.setText(tabelMember.getValueAt(tabelMember.getSelectedRow(), 3).toString());
        //dateLahirMember.setDate(jTable2.getValueAt(jTable2.getSelectedRow(), 4));
        noHpTxt.setText(tabelMember.getValueAt(tabelMember.getSelectedRow(), 5).toString());

        try {
            Date ku = new SimpleDateFormat("dd-MM-yyyy").parse(cel.getValueAt(tabelMember.getSelectedRow(), 4).toString());
            dateLahirMember.setDate(ku);
        } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelMemberMouseClicked

    private void buttonDeleteMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteMemberActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            try {
                cel.removeRow(tabelMember.getSelectedRow());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
            }
            //CLEAR TXT
            idMemberTxt.setText("");
            namaTxt.setText("");
            alamatTxt.setText("");
            noHpTxt.setText("");
            dateLahirMember.setDate(null);
        } else {
        }
    }//GEN-LAST:event_buttonDeleteMemberActionPerformed

    private void importBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBookBtnActionPerformed
        String filePath = "D:\\export file\\Buku.xls";
        File file = new File(filePath);
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                Vector data = new Vector();
                StringTokenizer st = new StringTokenizer(line, "\t");
                while (st.hasMoreTokens()) {
                    String nextToken = st.nextToken();
                    data.add(nextToken);
                }
                gra.addRow(data);
            }
            reader.close();

        } catch (Exception e) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
        }
        importBookBtn.setEnabled(false);
    }//GEN-LAST:event_importBookBtnActionPerformed

    private void exportBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBookBtnActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menyimpan data?", "Peringatan", buttonDialog);

        if (result == JOptionPane.YES_OPTION) {
            String filePath = "D:\\export file\\Buku.xls";
            File file = new File(filePath);

            try {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                    for (int j = 0; j < tabelBuku.getColumnCount(); j++) {
                        bw.write(tabelBuku.getValueAt(i, j).toString() + "\t");
                    }
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Susccess", "Information", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR", "Information", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }//GEN-LAST:event_exportBookBtnActionPerformed

    private void exportMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMemberActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menyimpan data?", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            String filePath = "D:\\export file\\Member.xls";
            File file = new File(filePath);

            try {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < tabelMember.getRowCount(); i++) {
                    for (int j = 0; j < tabelMember.getColumnCount(); j++) {
                        bw.write(tabelMember.getValueAt(i, j).toString() + "\t");
                    }
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Susccess", "Information", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR", "Information", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }//GEN-LAST:event_exportMemberActionPerformed

    private void importMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMemberActionPerformed
        String filePath = "D:\\export file\\Member.xls";
        File file = new File(filePath);
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                Vector data = new Vector();
                StringTokenizer st = new StringTokenizer(line, "\t");
                while (st.hasMoreTokens()) {
                    String nextToken = st.nextToken();
                    data.add(nextToken);
                }
                cel.addRow(data);
            }
            reader.close();

        } catch (Exception e) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
        }

        importMember.setEnabled(false);
    }//GEN-LAST:event_importMemberActionPerformed

    private void cariIDbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariIDbtnActionPerformed
        TableRowSorter<TableModel> ba = new TableRowSorter<>(tabelMember.getModel());
        tabelMember.setRowSorter(ba);
        List<RowSorter.SortKey> ka = new ArrayList<>();
        int kolomke = 0;
        ka.add(new RowSorter.SortKey(kolomke, SortOrder.ASCENDING));
        ba.setSortKeys(ka);
        ba.sort();

        try {
            int index = searchIDMember(tabelMember, cariID.getText(), 0, tabelMember.getRowCount());
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                cariID.setText("");
                labelNama.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Data ditemukan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            cariID.setText("");
            labelNama.setText("");
        }
    }//GEN-LAST:event_cariIDbtnActionPerformed

    private void cariKodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariKodeBtnActionPerformed
        TableRowSorter<TableModel> ba = new TableRowSorter<>(tabelBuku.getModel());
        tabelBuku.setRowSorter(ba);
        List<RowSorter.SortKey> ka = new ArrayList<>();
        int kolomke = 0;
        ka.add(new RowSorter.SortKey(kolomke, SortOrder.ASCENDING));
        ba.setSortKeys(ka);
        ba.sort();

        try {
            int index = searchKDBuku(tabelBuku, cariKode.getText(), 0, tabelBuku.getRowCount());
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                cariKode.setText("");
                labelJudul.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Data ditemukan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            cariKode.setText("");
            labelJudul.setText("");
        }
    }//GEN-LAST:event_cariKodeBtnActionPerformed

    private void pinjamAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamAddActionPerformed
    try {
            SimpleDateFormat dformat2 = new SimpleDateFormat("dd-MM-yyyy");
            String dateExp = dformat2.format(pinjamExp.getDate());
            String date = dformat2.format(pinjamDate.getDate());

            boolean belumAda = true;
            int jumlahBaris = tabelPinjam.getRowCount();
            int i;
            for (i = 0; i < jumlahBaris; i++) {
                if (cariKode.getText().equals(tabelPinjam.getValueAt(i, 2))) {
                    belumAda = false;
                    break;
                }}
            
            if (cariID.getText().isEmpty() | labelNama.getText().isEmpty() | cariKode.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data peminjaman tidak boleh kosong");
            } else if (belumAda) {
                rowPinjam(cariID.getText(), labelNama.getText(), cariKode.getText(), date, dateExp);
                cariID.setText("");
                labelNama.setText("");
                labelJudul.setText("");
                cariKode.setText("");
                pinjamDate.setDate(null);
                pinjamExp.setDate(null);
            } else {
                JOptionPane.showMessageDialog(null, "Buku sedang dipinjam");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong");
        }
    }//GEN-LAST:event_pinjamAddActionPerformed

    private void pinjamDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamDeleteActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            try {
                la.removeRow(tabelPinjam.getSelectedRow());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
            }
        } else {
        }
    }//GEN-LAST:event_pinjamDeleteActionPerformed

    private void pinjamExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamExportActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menyimpan data?", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            String filePath = "D:\\export file\\Pinjam.xls";
            File file = new File(filePath);

            try {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < tabelPinjam.getRowCount(); i++) {
                    for (int j = 0; j < tabelPinjam.getColumnCount(); j++) {
                        bw.write(tabelPinjam.getValueAt(i, j).toString() + "\t");
                    }
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Susccess", "Information", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR", "Information", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }//GEN-LAST:event_pinjamExportActionPerformed

    private void pinjamImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamImportActionPerformed
        String filePath = "D:\\export file\\Pinjam.xls";
        File file = new File(filePath);
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                Vector data = new Vector();
                StringTokenizer st = new StringTokenizer(line, "\t");
                while (st.hasMoreTokens()) {
                    String nextToken = st.nextToken();
                    data.add(nextToken);
                }
                la.addRow(data);
            }
            reader.close();

        } catch (Exception e) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
        }

        pinjamImport.setEnabled(false);
    }//GEN-LAST:event_pinjamImportActionPerformed

    private void cariPinjamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPinjamBtnActionPerformed
        String x = cariBuku.getText();
        boolean ketemu = false;
        int i;
        for (i = 0; i < tabelPinjam.getRowCount(); i++) {
            if (x.equals(tabelPinjam.getValueAt(i, 2))) {
                ketemu = true;
                break;
            }
        }
        if (ketemu) {
            JOptionPane.showMessageDialog(null, "Data ditemukan");
            labelPinjamID.setText(tabelPinjam.getValueAt(i, 0).toString());
            labelPinjamName.setText(tabelPinjam.getValueAt(i, 1).toString());
            labelTanggalPinjam.setText(tabelPinjam.getValueAt(i, 3).toString());
            labelBatasKembali.setText(tabelPinjam.getValueAt(i, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            cariBuku.setText("");
            labelPinjamID.setText("---");
            labelPinjamName.setText("---");
            labelTanggalPinjam.setText("---");
            labelBatasKembali.setText("---");
            kembaliDate.setDate(null);
            labelTelat.setText("");
            labelDenda.setText("");
        }
    }//GEN-LAST:event_cariPinjamBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SimpleDateFormat ya = new SimpleDateFormat("dd-MM-yyyy");
        Date ka = null;
        Date d2 = null;

        try {
            ka = ya.parse(labelBatasKembali.getText());
            d2 = ya.parse(ya.format(kembaliDate.getDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        long ba = d2.getTime() - ka.getTime();
        long hours = ba / (60 * 60 * 1000);
        long days = hours / 24;
        labelTelat.setText(Long.toString(days));

        int n = Integer.parseInt(labelTelat.getText());
        int Total = 0;
        if (n <= 0) {
            Total = 0 * 300;
        } else {
            Total = n * 300;
        }
        labelDenda.setText("Rp. " + Total);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReturnActionPerformed
        try {
            SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
            String dateReturn = dformat.format(kembaliDate.getDate());

            if (cariBuku.getText().isEmpty() | labelPinjamID.getText().isEmpty() | labelPinjamName.getText().isEmpty() | labelBatasKembali.getText().isEmpty() | labelTelat.getText().isEmpty() | labelDenda.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data pengembalian tidak boleh kosong");
            } else {
                String cari = cariBuku.getText();
                for (int i = 0; i < tabelPinjam.getRowCount(); i++) {
                    if (cari.equals(tabelPinjam.getValueAt(i, 2))) {
                        la.removeRow(i);
                        JOptionPane.showMessageDialog(null, "Book returned successfully");
                        break;
                    }
                }
                rowKembali(cariBuku.getText(), labelPinjamID.getText(), labelPinjamName.getText(), labelTanggalPinjam.getText(), labelBatasKembali.getText(), dateReturn, labelTelat.getText(), labelDenda.getText());
                cariBuku.setText("");
                labelPinjamID.setText("");
                labelPinjamName.setText("---");
                labelTanggalPinjam.setText("---");
                labelBatasKembali.setText("---");
                kembaliDate.setDate(null);
                labelTelat.setText("");
                labelDenda.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong");
        }
    }//GEN-LAST:event_addReturnActionPerformed

    private void kembaliExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliExportActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menyimpan data?", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            String filePath = "D:\\export file\\Kembali.xls";
            File file = new File(filePath);

            try {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < tabelPengembalian.getRowCount(); i++) {
                    for (int j = 0; j < tabelPengembalian.getColumnCount(); j++) {
                        bw.write(tabelPengembalian.getValueAt(i, j).toString() + "\t");
                    }
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Success", "Information", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
                fw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR", "Information", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }//GEN-LAST:event_kembaliExportActionPerformed

    private void kembaliImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliImportActionPerformed
        String filePath = "D:\\export file\\Kembali.xls";
        File file = new File(filePath);
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                Vector data = new Vector();
                StringTokenizer st = new StringTokenizer(line, "\t");
                while (st.hasMoreTokens()) {
                    String nextToken = st.nextToken();
                    data.add(nextToken);
                }
                ni.addRow(data);
            }
            reader.close();

        } catch (Exception e) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, e);
        }

        kembaliImport.setEnabled(false);
    }//GEN-LAST:event_kembaliImportActionPerformed

    private void kembaliDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliDeleteActionPerformed
        int buttonDialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Peringatan", buttonDialog);
        if (result == JOptionPane.YES_OPTION) {
            ni.removeRow(tabelPengembalian.getSelectedRow());
        } else {
        }
    }//GEN-LAST:event_kembaliDeleteActionPerformed

    private void jumlahPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPeminjamanActionPerformed
        int x = tabelPinjam.getRowCount();
        labelJumlahPinjam.setText(Integer.toString(x));
    }//GEN-LAST:event_jumlahPeminjamanActionPerformed

    private void jumlahPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPengembalianActionPerformed
        int x = tabelPengembalian.getRowCount();
        labelJumlahKembali.setText(Integer.toString(x));
    }//GEN-LAST:event_jumlahPengembalianActionPerformed

    private void jumlahBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBukuActionPerformed
        int x = tabelBuku.getRowCount();
        labelJumlahBuku.setText(Integer.toString(x));
    }//GEN-LAST:event_jumlahBukuActionPerformed

    private void jumlahMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahMemberActionPerformed
        int x = tabelMember.getRowCount();
        labelJumlahMember.setText(Integer.toString(x));
    }//GEN-LAST:event_jumlahMemberActionPerformed

    private void sembunyiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sembunyiMouseClicked
        //method showhide
        if (a == true) {
            hideshow(slidebarPanel, a, labelHide);
            SwingUtilities.updateComponentTreeUI(this);

            //method change image
            a = false;
        } else {
            hideshow(slidebarPanel, a, labelHide);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }

    }//GEN-LAST:event_sembunyiMouseClicked

    private void filterMemberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterMemberKeyReleased
        String key = filterMember.getText();
        TableRowSorter<DefaultTableModel> ya = new TableRowSorter<DefaultTableModel>(cel);
        tabelMember.setRowSorter(ya);
        ya.setRowFilter(RowFilter.regexFilter(key));
    }//GEN-LAST:event_filterMemberKeyReleased

    private void filterBukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterBukuKeyReleased
        String key = filterBuku.getText();
        TableRowSorter<DefaultTableModel> ya = new TableRowSorter<DefaultTableModel>(gra);
        tabelBuku.setRowSorter(ya);
        ya.setRowFilter(RowFilter.regexFilter(key));
    }//GEN-LAST:event_filterBukuKeyReleased

    private void filterMinjamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterMinjamKeyReleased
        String key = filterMinjam.getText();
        TableRowSorter<DefaultTableModel> ya = new TableRowSorter<DefaultTableModel>(la);
        tabelPinjam.setRowSorter(ya);
        ya.setRowFilter(RowFilter.regexFilter(key));
    }//GEN-LAST:event_filterMinjamKeyReleased

    private void filterKembaliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterKembaliKeyReleased
        String key = filterKembali.getText();
        TableRowSorter<DefaultTableModel> ya = new TableRowSorter<DefaultTableModel>(ni);
        tabelPengembalian.setRowSorter(ya);
        ya.setRowFilter(RowFilter.regexFilter(key));
    }//GEN-LAST:event_filterKembaliKeyReleased

    private void addKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKategoriActionPerformed
        String add = addKategoriTxt.getText();

        kategoriBox.addItem(add);
        addKategoriTxt.setText("");
    }//GEN-LAST:event_addKategoriActionPerformed

    private void deleteKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteKategoriActionPerformed
        kategoriBox.removeItemAt(kategoriBox.getSelectedIndex());
    }//GEN-LAST:event_deleteKategoriActionPerformed

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        clickmenu(menuHome, menuBooks, menuMember, menuPinjam, menuKembali, 1);

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(homePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_menuHomeMouseClicked

    private void menuBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBooksMouseClicked
        clickmenu(menuBooks, menuHome, menuMember, menuPinjam, menuKembali, 1);

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(bookPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_menuBooksMouseClicked

    private void menuMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMemberMouseClicked
        clickmenu(menuMember, menuHome, menuPinjam, menuBooks, menuKembali, 1);

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(memberPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_menuMemberMouseClicked

    private void menuPinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPinjamMouseClicked
        clickmenu(menuPinjam, menuHome, menuMember, menuBooks, menuKembali, 1);
        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(peminjamanPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_menuPinjamMouseClicked

    private void menuKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKembaliMouseClicked
        clickmenu(menuKembali, menuHome, menuPinjam, menuBooks, menuMember, 1);
        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(pengembalianPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_menuKembaliMouseClicked

    private void filterBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterBukuActionPerformed

    private void filterMinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterMinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterMinjamActionPerformed

    private void cariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariBukuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addKategori;
    private javax.swing.JTextField addKategoriTxt;
    private javax.swing.JButton addReturn;
    private javax.swing.JTextField alamatTxt;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel bookPanel;
    private javax.swing.ButtonGroup btnGender;
    private javax.swing.JButton buttonAddBooks;
    private javax.swing.JButton buttonAddMember;
    private javax.swing.JButton buttonDeleteBooks;
    private javax.swing.JButton buttonDeleteMember;
    private javax.swing.JButton buttonEditBooks;
    private javax.swing.JButton buttonEditMember;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JTextField cariBuku;
    private javax.swing.JTextField cariID;
    public javax.swing.JButton cariIDbtn;
    private javax.swing.JTextField cariKode;
    public javax.swing.JButton cariKodeBtn;
    private javax.swing.JButton cariPinjamBtn;
    private com.toedter.calendar.JDateChooser dateLahirMember;
    private javax.swing.JButton deleteKategori;
    private javax.swing.JButton exportBookBtn;
    private javax.swing.JButton exportMember;
    private javax.swing.JTextField filterBuku;
    private javax.swing.JTextField filterKembali;
    private javax.swing.JTextField filterMember;
    private javax.swing.JTextField filterMinjam;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel hidePanel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JTextField idMemberTxt;
    private javax.swing.JButton importBookBtn;
    private javax.swing.JButton importMember;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField judulBukuTxt;
    private javax.swing.JButton jumlahBuku;
    private javax.swing.JButton jumlahMember;
    private javax.swing.JButton jumlahPeminjaman;
    private javax.swing.JButton jumlahPengembalian;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private javax.swing.JComboBox kategoriBox;
    private com.toedter.calendar.JDateChooser kembaliDate;
    private javax.swing.JButton kembaliDelete;
    private javax.swing.JButton kembaliExport;
    private javax.swing.JButton kembaliImport;
    private javax.swing.JTextField kodeBukuTxt;
    private javax.swing.JLabel labelBatasKembali;
    private javax.swing.JLabel labelDenda;
    private javax.swing.JLabel labelHide;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelJumlahBuku;
    private javax.swing.JLabel labelJumlahKembali;
    private javax.swing.JLabel labelJumlahMember;
    private javax.swing.JLabel labelJumlahPinjam;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelPinjamID;
    private javax.swing.JLabel labelPinjamName;
    private javax.swing.JLabel labelTanggalPinjam;
    private javax.swing.JLabel labelTelat;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel memberPanel;
    private javax.swing.JPanel menuBooks;
    private javax.swing.JPanel menuHome;
    private javax.swing.JPanel menuKembali;
    private javax.swing.JPanel menuMember;
    private javax.swing.JPanel menuPinjam;
    private javax.swing.JTextField namaTxt;
    private javax.swing.JTextField noHpTxt;
    private javax.swing.JPanel peminjamanPanel;
    private javax.swing.JTextField penerbitTxt;
    private javax.swing.JTextField pengarangTxt;
    private javax.swing.JPanel pengembalianPanel;
    private javax.swing.JButton pinjamAdd;
    private com.toedter.calendar.JDateChooser pinjamDate;
    private javax.swing.JButton pinjamDelete;
    private com.toedter.calendar.JDateChooser pinjamExp;
    private javax.swing.JButton pinjamExport;
    private javax.swing.JButton pinjamImport;
    private javax.swing.JTextField posisi;
    private javax.swing.JRadioButton radioBtnLaki;
    private javax.swing.JRadioButton radioBtnPerempuan;
    private javax.swing.JTextField rakBuku;
    private javax.swing.JPanel sembunyi;
    private javax.swing.JPanel slidebarPanel;
    public javax.swing.JTable tabelBuku;
    private javax.swing.JTable tabelMember;
    private javax.swing.JTable tabelPengembalian;
    private javax.swing.JTable tabelPinjam;
    private com.toedter.calendar.JYearChooser thnTerbit;
    // End of variables declaration//GEN-END:variables

}
