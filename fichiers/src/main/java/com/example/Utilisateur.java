package com.example;

/**
 * Created by eleves on 16-05-26.
 */
public class Utilisateur {
    private String NonCli;
    private String PreNonCli;
    private int CodeCli = 0;
    private String EMailCli;
    private String AdRueCli;
    private int AdNumeroCli = 0;
    private String AdVilleCli;
    private String AdPaysCli;
    private int PhoneCli = 0;
    private int AgeCli = 0;
    private String logCli;
    private String MotPass;


    public String getMotPass() {
        return MotPass;
    }

    public void setMotPass(String motPass) {
        MotPass = motPass;
    }

    public String getNonCli() {
        return NonCli;
    }

    public void setNonCli(String nonCli) {
        NonCli = nonCli;
    }

    public String getPreNonCli() {
        return PreNonCli;
    }

    public void setPreNonCli(String preNonCli) {
        PreNonCli = preNonCli;
    }

    public int getCodeCli() {
        return CodeCli;
    }

    public void setCodeCli(int codeCli) {
        CodeCli = codeCli;
    }

    public String getEMailCli() {
        return EMailCli;
    }

    public void setEMailCli(String EMailCli) {
        this.EMailCli = EMailCli;
    }

    public String getAdRueCli() {
        return AdRueCli;
    }

    public void setAdRueCli(String adRueCli) {
        AdRueCli = adRueCli;
    }

    public int getAdNumeroCli() {
        return AdNumeroCli;
    }

    public void setAdNumeroCli(int adNumeroCli) {
        AdNumeroCli = adNumeroCli;
    }

    public String getAdVilleCli() {
        return AdVilleCli;
    }

    public void setAdVilleCli(String adVilleCli) {
        AdVilleCli = adVilleCli;
    }

    public String getAdPaysCli() {
        return AdPaysCli;
    }

    public void setAdPaysCli(String adPaysCli) {
        AdPaysCli = adPaysCli;
    }

    public int getPhoneCli(int i) {
        return PhoneCli;
    }

    public void setPhoneCli(int phoneCli) {
        PhoneCli = phoneCli;
    }

    public int getAgeCli() {
        return AgeCli;
    }

    public void setAgeCli(int ageCli) {
        AgeCli = ageCli;
    }

    public String getLogCli() {
        return logCli;
    }

    public void setLogCli(String logCli) {
        this.logCli = logCli;
    }

}
