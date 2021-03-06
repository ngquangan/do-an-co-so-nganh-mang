package com.ngquangan.UI;

import com.ngquangan.Server.ServerImpl;
import com.ngquangan.bean.CanBo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class UIInfo extends JFrame {

    JLabel lblXinChao;
    JTextField txtMaSo;
    JTextField txtHoTen;
    JTextField txtNgaySinh;
    JTextField txtGioiTinh;
    JTextField txtSoDT;
    JTextField txtEmail;
    JTextField txtPhongBan;
    JTextField txtChucVu;
    JTextField txtUsername;

    JButton btnCapNhat;
    JButton btnTroVe;
    String username;
    ServerImpl server;
    CanBo cb = null;

    public UIInfo(String title, String username) {

        super(title);
        this.username = username;

        try {
            server = new ServerImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        cb = server.getInfo(username);

        addControls();
        addEvents();
    }

    public void showWindow() {
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void addControls() {

        Container con = getContentPane();

        JPanel pn = new JPanel();
        pn.setLayout(new BorderLayout());
        con.add(pn);

        JPanel pnCenter = new JPanel();
        pn.add(pnCenter, BorderLayout.CENTER);

        JPanel pnMaSo = new JPanel();
        pnMaSo.setLayout(new FlowLayout());
        pnCenter.add(pnMaSo);

        JLabel lblMaSo = new JLabel("Mã Số: ");
        pnMaSo.add(lblMaSo);

        txtMaSo = new JTextField(30);
        txtMaSo.setEditable(false);
        txtMaSo.setBackground(Color.LIGHT_GRAY);
        pnMaSo.add(txtMaSo);

        JPanel pnHoTen = new JPanel();
        pnHoTen.setLayout(new FlowLayout());
        pnCenter.add(pnHoTen);

        JLabel lblHoTen = new JLabel("Họ Tên: ");
        pnHoTen.add(lblHoTen);

        txtHoTen = new JTextField(30);
        txtHoTen.setEditable(false);
        txtHoTen.setBackground(Color.LIGHT_GRAY);
        pnHoTen.add(txtHoTen);

        JPanel pnNgaySinh = new JPanel();
        pnNgaySinh.setLayout(new FlowLayout());
        pnCenter.add(pnNgaySinh);

        JLabel lblNgaySinh = new JLabel("Ngày Sinh: ");
        pnNgaySinh.add(lblNgaySinh);

        txtNgaySinh = new JTextField(30);
        txtNgaySinh.setEditable(false);
        txtNgaySinh.setBackground(Color.LIGHT_GRAY);
        pnNgaySinh.add(txtNgaySinh);

        JPanel pnGioiTinh = new JPanel();
        pnGioiTinh.setLayout(new FlowLayout());
        pnCenter.add(pnGioiTinh);

        JLabel lblGioiTinh = new JLabel("Giới Tính: ");
        pnGioiTinh.add(lblGioiTinh);

        txtGioiTinh = new JTextField(30);
        txtGioiTinh.setEditable(false);
        txtGioiTinh.setBackground(Color.LIGHT_GRAY);
        pnGioiTinh.add(txtGioiTinh);

        JPanel pnSoDT = new JPanel();
        pnSoDT.setLayout(new FlowLayout());
        pnCenter.add(pnSoDT);

        JLabel lblSoDT = new JLabel("Số ĐT: ");
        pnSoDT.add(lblSoDT);

        txtSoDT = new JTextField(30);
        txtSoDT.setEditable(false);
        txtSoDT.setBackground(Color.LIGHT_GRAY);
        pnSoDT.add(txtSoDT);

        JPanel pnEmail = new JPanel();
        pnEmail.setLayout(new FlowLayout());
        pnCenter.add(pnEmail);

        JLabel lblEmail = new JLabel("Email: ");
        pnEmail.add(lblEmail);

        txtEmail = new JTextField(30);
        txtEmail.setEditable(false);
        txtEmail.setBackground(Color.LIGHT_GRAY);
        pnEmail.add(txtEmail);

        JPanel pnPhongBan = new JPanel();
        pnPhongBan.setLayout(new FlowLayout());
        pnCenter.add(pnPhongBan);

        JLabel lblPhongBan = new JLabel("Phòng Ban: ");
        pnPhongBan.add(lblPhongBan);

        txtPhongBan = new JTextField(30);
        txtPhongBan.setEditable(false);
        txtPhongBan.setBackground(Color.LIGHT_GRAY);
        pnPhongBan.add(txtPhongBan);

        JPanel pnChucVu = new JPanel();
        pnChucVu.setLayout(new FlowLayout());
        pnCenter.add(pnChucVu);

        JLabel lblChucVu = new JLabel("Chức Vụ: ");
        pnChucVu.add(lblChucVu);

        txtChucVu = new JTextField(30);
        txtChucVu.setEditable(false);
        txtChucVu.setBackground(Color.LIGHT_GRAY);
        pnChucVu.add(txtChucVu);

        JPanel pnUsername = new JPanel();
        pnUsername.setLayout(new FlowLayout());
        pnCenter.add(pnUsername);

        JLabel lblUsername = new JLabel("Username: ");
        pnUsername.add(lblUsername);

        txtUsername = new JTextField(30);
        txtUsername.setEditable(false);
        txtUsername.setBackground(Color.LIGHT_GRAY);
        pnUsername.add(txtUsername);

        JPanel pnBottom = new JPanel();
        pn.add(pnBottom, BorderLayout.SOUTH);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout());
        pnBottom.add(pnButton);

        btnCapNhat = new JButton("Cập nhật");
        pnButton.add(btnCapNhat);

        btnTroVe = new JButton("Trở về");
        pnButton.add(btnTroVe);

        //set Data

        txtMaSo.setText(cb.getMaNV());
        txtHoTen.setText(cb.getTeNV());
        txtNgaySinh.setText(cb.getNgaySinh().toString());
        txtGioiTinh.setText(cb.isGioiTinh() ? "Nam" : "Nữ");
        txtSoDT.setText(cb.getSoDT());
        txtEmail.setText(cb.getEmail());
        txtPhongBan.setText(cb.getPhongBan());
        txtChucVu.setText(cb.getChucVu());
        txtUsername.setText(cb.getUsername());

    }

    public void addEvents() {

        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIEditInfo uiEditInfo = new UIEditInfo("Cập nhật thông tin cán bộ", username);
                uiEditInfo.showWindow();
                dispose();
            }
        });

        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManage uiManage = new UIManage("Quản lý cán bộ");
                uiManage.showWindow();
                dispose();
            }
        });

    }

}
