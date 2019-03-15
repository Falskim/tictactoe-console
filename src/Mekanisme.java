/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTicTac;
/**
 *
 * @author Falskim
 */
public class Mekanisme {
    /**
        A=Atas
        Ki=Kiri
        T=Tengah
        Ka=Kanan
        B=Bawah
    */
    char isiAKi,isiAT,isiAKa;
    char isiTKi,isiTT,isiTKa;
    char isiBKi,isiBT,isiBKa;
    char logoSatu,logoDua;
    boolean kosongAKi,kosongAT,kosongAKa;
    boolean kosongTKi,kosongTT,kosongTKa;
    boolean kosongBKi,kosongBT,kosongBKa;
    boolean gameFinished,enemyTurnPassed,singlePlayer;
    String namaPlayerSatu,namaPlayerDua;
    int turn=0,winner=0; //Winner 1=Player1 2=Enemy/Player2
    Display disp=new Display();
    public void gameBase(){
        setSingleMulti();
        setNamaPlayer();
        setLogo();
        setNilaiAwal();
        disp.tampilGame(1,singlePlayer);
        setNilaiProses();
        if (singlePlayer)
            modeSinglePlayer();
        else
            modeMultiPlayer();
        disp.gameWinner(winner,singlePlayer);
    }
    private void setSingleMulti(){
        singlePlayer=disp.setSingleMulti();
    }
    private void setLogo(){
        logoSatu=disp.setLogo(1);
        if(singlePlayer)
            logoDua=disp.setLogo(0);
        else
            logoDua=disp.setLogo(2);
    }
    private void setNilaiAwal(){
        this.isiAKi=this.isiAT=this.isiAKa=this.isiTKi=this.isiTT=this.isiTKa=this.isiBKi=this.isiBT=this.isiBKa=' ';
        this.kosongAKi=this.kosongAT=this.kosongAKa=this.kosongTKi=this.kosongTT=this.kosongTKa=this.kosongBKi=this.kosongBT=this.kosongBKa=true;
        gameFinished=enemyTurnPassed=false;
    }
    private void setNilaiProses(){
        disp.setIsi(isiAKi,isiAT,isiAKa,isiTKi,isiTT,isiTKa,isiBKi,isiBT,isiBKa);
        disp.setKosong(kosongAKi, kosongAT, kosongAKa, kosongTKi, kosongTT, kosongTKa, kosongBKi, kosongBT, kosongBKa);
    }
    private void setNamaPlayer(){
        namaPlayerSatu=disp.setNama(1);
        if(!singlePlayer)
            namaPlayerDua=disp.setNama(2);
    }
    private void modeSinglePlayer(){
        for(;;){
            disp.opsiList(turn);
            if(gameFinished)
                break;
            disp.setOpsi(false);
            playerSatuTurn(disp.getOpsi());
            playerSatuWinCondition();
            setNilaiProses();
            turn++;
            disp.tampilGame(turn,singlePlayer);
            disp.opsiList(turn);
            if(turn==9||gameFinished)
                break;
            disp.turnMusuh();
            enemyMasterTurn();
            setNilaiProses();
            turn++;
            disp.tampilGame(turn,singlePlayer);
        }
    }
    private void modeMultiPlayer(){
        for(;;){
            disp.opsiList(turn);
            if(gameFinished)
                break;
            disp.setOpsi(false);
            playerSatuTurn(disp.getOpsi());
            playerSatuWinCondition();
            setNilaiProses();
            turn++;
            disp.tampilGame(turn,singlePlayer);
            disp.opsiList(turn);
            if(turn==9||gameFinished)
                break;
            disp.opsiList(turn);
            disp.setOpsi(false);
            playerDuaTurn(disp.getOpsi());
            playerDuaWinCondition();
            setNilaiProses();
            turn++;
            disp.tampilGame(turn,singlePlayer);
        }
    }
    private void enemyFirstTurn(String kode){
        if(kode.equals("tt")){
            isiAKi=logoDua;
            kosongAKi=false;
        }else{
            isiTT=logoDua;
            kosongTT=false;
        }
        enemyTurnPassed=true;
    }
    private void enemyElseTurn(){
        if(isiAKi==logoDua&& !kosongAKi){
            if(kosongTT){
                isiTT=logoDua;
                kosongTT=false;
            }else if(kosongBKi){
                isiBKi=logoDua;
                kosongBKi=false;        
            }else if(kosongAKa){
                isiAKa=logoDua;
                kosongAKa=false;
            }else if(kosongAT){
                isiAT=logoDua;
                kosongAT=false;
            }else if(kosongTKi){
                isiTKi=logoDua;
                kosongTKi=false;
            }
        }else if(isiTT==logoDua&& !kosongTT){
            if(kosongAKi){
                isiAKi=logoDua;
                kosongAKi=false;
            } else if(kosongAKa){
                isiAKa=logoDua;
                kosongAKa=false;
            } else if(kosongBKi){
                isiBKi=logoDua;
                kosongBKi=false;
            } else if(kosongBKa){
                isiBKa=logoDua;
                kosongBKa=false;
            }
        }
    }
    private void enemyFinisherTurn(){
        enemyTurnPassed=true;
        if(kosongAKi&&(isiAT==logoDua&&isiAKa==logoDua || isiTKi==logoDua&&isiBKi==logoDua || isiTT==logoDua&&isiBKa==logoDua)){
            isiAKi=logoDua;
            kosongAKi=false;
            winner=2;
            gameFinished=true;
        }else if(kosongAT&&(isiAKi==logoDua&&isiAKa==logoDua || isiTT==logoDua&&isiBT==logoDua)){
            isiAT=logoDua;
            kosongAT=false;
            winner=2;
            gameFinished=true;
        }else if(kosongAKa&&(isiAT==logoDua&&isiAKi==logoDua || isiTKa==logoDua&&isiBKa==logoDua || isiTT==logoDua&&isiBKi==logoDua)){
            isiAKa=logoDua;
            kosongAKa=false;
            winner=2;
            gameFinished=true;
        }else if(kosongTKi&&(isiAKi==logoDua&&isiBKi==logoDua || isiTT==logoDua&&isiTKa==logoDua)){
            isiTKi=logoDua;
            kosongTKi=false;
            winner=2;
            gameFinished=true;
        }else if(kosongTT&&(isiAKi==logoDua&&isiBKa==logoDua || isiAT==logoDua&&isiBT==logoDua || isiAKa==logoDua&&isiBKi==logoDua || isiTKi==logoDua&&isiTKa==logoDua)){
            isiTT=logoDua;
            kosongTT=false;
            winner=2;
            gameFinished=true;
        }else if(kosongTKa&&(isiAKa==logoDua&&isiBKa==logoDua || isiTT==logoDua&&isiTKi==logoDua)){
            isiTKa=logoDua;
            kosongTKa=false;
            winner=2;
            gameFinished=true;
        }else if(kosongBKi&&(isiBT==logoDua&&isiBKa==logoDua || isiTKi==logoDua&&isiAKi==logoDua || isiTT==logoDua&&isiAKa==logoDua)){
            isiBKi=logoDua;
            kosongBKi=false;
            winner=2;
            gameFinished=true;
        }else if(kosongBT&&(isiAT==logoDua&&isiTT==logoDua || isiBKi==logoDua&&isiBKa==logoDua)){
            isiBT=logoDua;
            kosongBT=false;
            winner=2;
            gameFinished=true;
        }else if(kosongBKa&&(isiBKi==logoDua&&isiBT==logoDua || isiTKa==logoDua&&isiAKa==logoDua || isiTT==logoDua&&isiAKi==logoDua)){
            isiBKa=logoDua;
            kosongBKa=false;
            winner=2;
            gameFinished=true;
        }else
            enemyTurnPassed=false;
    }
    private void enemyBaseTurn(){
        enemyTurnPassed=true;
        if(kosongAKi&&(isiAT==logoSatu&& isiAKa==logoSatu || isiTKi==logoSatu&&isiBKi==logoSatu)){
            isiAKi=logoDua;
            kosongAKi=false;
        }else if(kosongAT&&(isiAKi==logoSatu&& isiAKa==logoSatu || isiTT==logoSatu&&isiBT==logoSatu)){
            isiAT=logoDua;
            kosongAT=false;
        }else if(kosongAKa&&(isiAKi==logoSatu&& isiAT==logoSatu || isiTT==logoSatu&&isiBKi==logoSatu)){
            isiAKa=logoDua;
            kosongAKa=false;
        }else if(kosongTKi&&(isiAKi==logoSatu&& isiBKi==logoSatu || isiTT==logoSatu&&isiTKa==logoSatu)){
            isiTKi=logoDua;
            kosongTKi=false;
        }else if(kosongTT&&(isiAKi==logoSatu&& isiBKa==logoSatu || isiAT==logoSatu&&isiBT==logoSatu || isiAKa==logoSatu&& isiBKi==logoSatu || isiTKi==logoSatu&&isiTKa==logoSatu)){
            isiTT=logoDua;
            kosongTT=false;
        }else if(kosongTKa&&(isiAKa==logoSatu&& isiBKa==logoSatu || isiTT==logoSatu&&isiTKi==logoSatu)){
            isiTKa=logoDua;
            kosongTKa=false;
        }else if(kosongBKi&&(isiAKi==logoSatu&& isiTKi==logoSatu || isiTT==logoSatu&&isiAKa==logoSatu)){
            isiBKi=logoDua;
            kosongBKi=false;
        }else if(kosongBT&&(isiBKi==logoSatu&& isiBKa==logoSatu || isiTT==logoSatu&&isiAT==logoSatu)){
            isiBT=logoDua;
            kosongBT=false;
        }else if(kosongBKa&&(isiBKi==logoSatu&& isiBT==logoSatu || isiTT==logoSatu&&isiAKi==logoSatu)){
            isiBKa=logoDua;
            kosongBKa=false;
        }else if(!gameFinished)
            enemyTurnPassed=false;
    }
    private void enemyMasterTurn(){
        enemyFinisherTurn();
        if (!gameFinished){
            if (turn==1&&!enemyTurnPassed){
                enemyFirstTurn(disp.getOpsi());
            }else{
                enemyBaseTurn();
            }
            if(!enemyTurnPassed)
                enemyElseTurn();
        }
    }
    private void playerSatuTurn(String kode){
        if(kode.equals("aki")&&kosongAKi){
            isiAKi=logoSatu;
            kosongAKi=false;
        }else if(kode.equals("at")&&kosongAT){
            isiAT=logoSatu;
            kosongAT=false;
        }else if(kode.equals("aka")&&kosongAKa){
            isiAKa=logoSatu;
            kosongAKa=false;
        }else if(kode.equals("tki")&&kosongTKi){
            isiTKi=logoSatu;
            kosongTKi=false;
        }else if(kode.equals("tt")&&kosongTT){
            isiTT=logoSatu;
            kosongTT=false;
        }else if(kode.equals("tka")&&kosongTKa){
            isiTKa=logoSatu;
            kosongTKa=false;
        }else if(kode.equals("bki")&&kosongBKi){
            isiBKi=logoSatu;
            kosongBKi=false;
        }else if(kode.equals("bt")&&kosongBT){
            isiBT=logoSatu;
            kosongBT=false;
        }else if(kode.equals("bka")&&kosongBKa){
            isiBKa=logoSatu;
            kosongBKa=false;
        }else{
            disp.setOpsi(true);
            playerSatuTurn(disp.getOpsi());
        }
    }
    private void playerDuaTurn(String kode){
        if(kode.equals("aki")&&kosongAKi){
            isiAKi=logoDua;
            kosongAKi=false;
        }else if(kode.equals("at")&&kosongAT){
            isiAT=logoDua;
            kosongAT=false;
        }else if(kode.equals("aka")&&kosongAKa){
            isiAKa=logoDua;
            kosongAKa=false;
        }else if(kode.equals("tki")&&kosongTKi){
            isiTKi=logoDua;
            kosongTKi=false;
        }else if(kode.equals("tt")&&kosongTT){
            isiTT=logoDua;
            kosongTT=false;
        }else if(kode.equals("tka")&&kosongTKa){
            isiTKa=logoDua;
            kosongTKa=false;
        }else if(kode.equals("bki")&&kosongBKi){
            isiBKi=logoDua;
            kosongBKi=false;
        }else if(kode.equals("bt")&&kosongBT){
            isiBT=logoDua;
            kosongBT=false;
        }else if(kode.equals("bka")&&kosongBKa){
            isiBKa=logoDua;
            kosongBKa=false;
        }else{
            disp.setOpsi(true);
            playerSatuTurn(disp.getOpsi());
        }
    }
    private void playerSatuWinCondition(){
        if(isiAKi==logoSatu&&isiAT==logoSatu&&isiAKa==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiTKi==logoSatu&&isiTT==logoSatu&&isiTKa==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiBKi==logoSatu&&isiBT==logoSatu&&isiBKa==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiAKi==logoSatu&&isiTKi==logoSatu&&isiBKi==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiAT==logoSatu&&isiTT==logoSatu&&isiBT==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiAKa==logoSatu&&isiTKa==logoSatu&&isiBKa==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiAKi==logoSatu&&isiTT==logoSatu&&isiBKa==logoSatu){
            winner=1;
            gameFinished=true;
        }else if(isiAKa==logoSatu&&isiTT==logoSatu&&isiBKi==logoSatu){
            winner=1;
            gameFinished=true;
        }
    }
    private void playerDuaWinCondition(){
        if(isiAKi==logoDua&&isiAT==logoDua&&isiAKa==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiTKi==logoDua&&isiTT==logoDua&&isiTKa==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiBKi==logoDua&&isiBT==logoDua&&isiBKa==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiAKi==logoDua&&isiTKi==logoDua&&isiBKi==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiAT==logoDua&&isiTT==logoDua&&isiBT==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiAKa==logoDua&&isiTKa==logoDua&&isiBKa==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiAKi==logoDua&&isiTT==logoDua&&isiBKa==logoDua){
            winner=2;
            gameFinished=true;
        }else if(isiAKa==logoDua&&isiTT==logoDua&&isiBKi==logoDua){
            winner=2;
            gameFinished=true;
        }
    }
}
