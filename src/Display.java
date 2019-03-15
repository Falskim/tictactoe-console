/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTicTac;
import static java.lang.System.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Falskim
 */
public class Display{
    private char isiAKi,isiAT,isiAKa;
    private char isiTKi,isiTT,isiTKa;
    private char isiBKi,isiBT,isiBKa;
    private boolean kosongAKi,kosongAT,kosongAKa;
    private boolean kosongTKi,kosongTT,kosongTKa;
    private boolean kosongBKi,kosongBT,kosongBKa;
    char logoPlayerSatu,logoPlayerDua;
    String opsi,daftarOpsi,gambarTabel,namaPlayerSatu,namaPlayerDua;
    public void opsiList(int cek){
        daftarOpsi="";
        int x=1;
        if(cek!=9){
            daftarOpsi+="Posisi Yang Tersedia :";
            if(kosongAKi){
                daftarOpsi+=("\n"+x+")Atas Kiri <aki>");
                x++;
            }
            if(kosongAT){
                daftarOpsi+=("\n"+x+")Atas Tengah <at>");
                x++;
            }
            if(kosongAKa){
                daftarOpsi+=("\n"+x+")Atas Kanan <aka>");
                x++;
            }
            if(kosongTKi){
                daftarOpsi+=("\n"+x+")Tengah Kiri <tki>");
                x++;
            }
            if(kosongTT){
                daftarOpsi+=("\n"+x+")Tengah <tt>");
                x++;
            }
            if(kosongTKa){
                daftarOpsi+=("\n"+x+")Tengah Kanan <tka>");
                x++;
            }
            if(kosongBKi){
                daftarOpsi+=("\n"+x+")Bawah Kiri <bki>");
                x++;
            }        
            if(kosongBT){
                daftarOpsi+=("\n"+x+")Bawah Tengah <bt>");
                x++;
            }
            if(kosongBKa){
                daftarOpsi+=("\n"+x+")Bawah Kanan <bka>");
                x++;
            }
        }else
            daftarOpsi+=("\n"+"Posisi Yang Tersedia Telah Habis");
        /**
        if(cek!=9){
            out.println("Posisi Yang Tersedia :");
            if(kosongAKi){
                out.println(x+")Atas Kiri <aki>");
                x++;
            }
            if(kosongAT){
                out.println(x+")Atas Tengah <at>");
                x++;
            }
            if(kosongAKa){
                out.println(x+")Atas Kanan <aka>");
                x++;
            }
            if(kosongTKi){
                out.println(x+")Tengah Kiri <tki>");
                x++;
            }
            if(kosongTT){
                out.println(x+")Tengah <tt>");
                x++;
            }
            if(kosongTKa){
                out.println(x+")Tengah Kanan <tka>");
                x++;
            }
            if(kosongBKi){
                out.println(x+")Bawah Kiri <bki>");
                x++;
            }        
            if(kosongBT){
                out.println(x+")Bawah Tengah <bt>");
                x++;
            }
            if(kosongBKa){
                out.println(x+")Bawah Kanan <bka>");
                x++;
            }
        }else
            out.println("Posisi Yang Tersedia Telah Habis");
        */
    }
    public void setIsi(char aki,char at,char aka,char tki,char tt,char tka,char bki,char bt,char bka){
        isiAKi=aki;
        isiAT=at;
        isiAKa=aka;
        isiTKi=tki;
        isiTT=tt;
        isiTKa=tka;
        isiBKi=bki;
        isiBT=bt;
        isiBKa=bka;
    }
    public void setKosong(boolean aki,boolean at,boolean aka,boolean tki,boolean tt,boolean tka,boolean bki,boolean bt,boolean bka){
        kosongAKi=aki;
        kosongAT=at;
        kosongAKa=aka;
        kosongTKi=tki;
        kosongTT=tt;
        kosongTKa=tka;
        kosongBKi=bki;
        kosongBT=bt;
        kosongBKa=bka;
    }
    public void setOpsi(boolean error){
        if(error){
            JOptionPane.showMessageDialog(null, "Input Salah, Masukan Kode Yang Tersedia");
        }
        opsi=JOptionPane.showInputDialog(daftarOpsi+"\n\nSilahkan Masukan Kode Pilihan");
    }
    public String getOpsi(){
        return this.opsi;
    }
    public void tampilGame(int turn,boolean singlePlayer){
        gambarTabel="";
        gambarTabel+=("    Turn "+turn);
        if(turn==1){
            if(singlePlayer){
                gambarTabel+=("\n\n"+namaPlayerSatu+"\t: "+logoPlayerSatu);
                gambarTabel+=("\nBot\t: "+logoPlayerDua);
            }else{
                gambarTabel+=("\n\n"+namaPlayerSatu+"\t: "+logoPlayerSatu);
                gambarTabel+=("\n"+namaPlayerDua+"\t: "+logoPlayerDua);
            }
        }
        gambarTabel+=("\n\n+---+---+---+");
        gambarTabel+=("\n| "+isiAKi+" | "+isiAT+" | "+isiAKa+" |");
        gambarTabel+=("\n+---+---+---+");
        gambarTabel+=("\n| "+isiTKi+" | "+isiTT+" | "+isiTKa+" |");
        gambarTabel+=("\n+---+---+---+");
        gambarTabel+=("\n| "+isiBKi+" | "+isiBT+" | "+isiBKa+" |");
        gambarTabel+=("\n+---+---+---+\n\n");
        out.println(gambarTabel);
    }
    public void turnMusuh(){
        JOptionPane.showMessageDialog(null, "Sekarang Giliran Musuh", "Game Tic Tac Toe", 2);
    }
    public void gameWinner(int win,boolean mode){
        if(mode){
            switch (win){
            case 0:
                JOptionPane.showMessageDialog(null, "-= Hasilnya Draw =-");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Selamat Anda Menang !!!");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Maaf Anda Kalah...");
                break;            
            }
        }else{
            switch (win){
            case 0:
                JOptionPane.showMessageDialog(null, "-= Hasilnya Draw =-");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Selamat "+namaPlayerSatu+" Menang");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Selamat "+namaPlayerDua+" Menang");
                break;
            }
        }        
    }
    public char setLogo(int y){
        String x;
        char logo;
        switch(y){
            case 1:
                x=JOptionPane.showInputDialog("Masukan Icon Huruf Player 1\n(apabila lebih dari 1 karakter, akan diambil karakter pertama)");
                break;
            case 2:
                x=JOptionPane.showInputDialog("Masukan Icon Huruf Player 2\n(apabila lebih dari 1 karakter, akan diambil karakter pertama)");
                break;
            default:
                x=JOptionPane.showInputDialog("Masukan Icon Huruf Bot\n(apabila lebih dari 1 karakter, akan diambil karakter pertama)");
                break;
        }
        logo=x.charAt(0);
        switch(y){
            case 1:
                logoPlayerSatu=logo;
                break;
            default:
                logoPlayerDua=logo;
                break;
        }
        return logo;
    }
    public boolean setSingleMulti(){
        for(;;){
        String jumlahPlayer=JOptionPane.showInputDialog("Pilih Mode Permainan (single/multi)");
        if (jumlahPlayer.equals("single"))
            return true;
        else if(jumlahPlayer.equals("multi"))
            return false;
        else
            JOptionPane.showMessageDialog(null, "Input Salah !!!");
        }
    }
    public String setNama(int mode){
        switch(mode){
            case 1:
                namaPlayerSatu=JOptionPane.showInputDialog("Masukan Nama Player "+mode);
                return namaPlayerSatu;
            default:
                namaPlayerDua=JOptionPane.showInputDialog("Masukan Nama Player "+mode);
                return namaPlayerDua;
        }
    }
}
