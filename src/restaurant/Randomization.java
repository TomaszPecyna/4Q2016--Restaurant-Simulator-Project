/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;

/**
 *
 * @author Tomek
 */
public class Randomization
{
    private ArrayList<String> names;
    private ArrayList<String> surnames;
    private ArrayList<String> PESELs;
    private ArrayList<String> registrationNumbers;
    private ArrayList<String> phone;
    private ArrayList<String> email;
    private ArrayList<String> adress;
    private ArrayList<String> bank;
    private ArrayList<String> REGON;
    
    public Randomization()
    {
        phone = new ArrayList<>();
        names = new ArrayList<>();
        surnames = new ArrayList<>();
        PESELs = new ArrayList<>();
        registrationNumbers = new ArrayList<>();
        phone = new ArrayList<>();
        email = new ArrayList<>();
        adress = new ArrayList<>();
        bank = new ArrayList<>();
        REGON = new ArrayList<>();
        
        names.add("Janushi");
        names.add("Darek");
        names.add("Edwin");
        names.add("Mieczysław");
        names.add("Izydor");
        names.add("Nina");
        names.add("Weronika");
        names.add("Henryk");
        names.add("Małgorzata");
        names.add("Ludwik");
        names.add("Martyna");
        names.add("Arnold");
        names.add("Daniel");
        names.add("Anna");
        names.add("Emilia");
        
        surnames.add("Nowak");
        surnames.add("Kowalski");
        surnames.add("Odesseiron");
        surnames.add("Wiśniewski");
        surnames.add("Dąbrowski");
        surnames.add("Lewandowski");
        surnames.add("Wójcik");
        surnames.add("Kamiński");
        surnames.add("Kowalczyk");
        surnames.add("Zieliński");
        surnames.add("Szymański");
        surnames.add("Woźniak");
        surnames.add("Kozłowski");
        surnames.add("Jankowski");
        surnames.add("Wojciechowski");
        
        PESELs.add("36010707334");
        PESELs.add("82022701884");
        PESELs.add("91051317478");
        PESELs.add("03220617049");
        PESELs.add("69012307479");
        PESELs.add("02290505023");
        PESELs.add("75121103934");
        PESELs.add("84030105845");
        PESELs.add("04270805101");
        PESELs.add("12262915868");
        PESELs.add("71100801093");
        PESELs.add("23061801902");
        PESELs.add("07221012704");
        PESELs.add("67103007901");
        PESELs.add("70070116679");
        
        registrationNumbers.add("D7PN1490TW");
        registrationNumbers.add("4ZUQTIEJNI");
        registrationNumbers.add("TMHZ3NCG1S");
        registrationNumbers.add("E5PUIGOI77");
        registrationNumbers.add("41XPHGXMQB");
        registrationNumbers.add("V9N2ZHG1N7");
        registrationNumbers.add("KS3ZCB6RJ4");
        registrationNumbers.add("OEVCU3IIFZ");
        registrationNumbers.add("K1YXUN50FI");
        registrationNumbers.add("YP1RF4TBL3");
        registrationNumbers.add("508R2SLB1R");
        registrationNumbers.add("2GNUXSPGU0");
        registrationNumbers.add("AQR88JQJLH");
        registrationNumbers.add("0BI9Q71JRK");
        registrationNumbers.add("IKQV5EEKLZ");
        registrationNumbers.add("ALFRJE10NC");
        registrationNumbers.add("7EEGDUE44V");
        
        phone.add("793400859");
        phone.add("799463411");
        phone.add("783620581");
        phone.add("506890170");
        phone.add("883683351");
        phone.add("575249373");
        phone.add("787572499");
        phone.add("883455847");
        phone.add("699650271");
        phone.add("793377108");
        phone.add("667125682");
        phone.add("787079305");
        phone.add("793995724");
        phone.add("664596116");
        phone.add("665735967");
        phone.add("699085581");
        phone.add("786323056");
        
        email.add("lolebosu-2499@yopmail.com");
        email.add("regekuqoba-4309@yopmail.com");
        email.add("derrummemosse-9312@yopmail.com");
        email.add("lassizassig-6902@yopmail.com");
        email.add("mygannomelle-2817@yopmail.com");
        email.add("fummefyjurr-9735@yopmail.com");
        email.add("ejifulim-4634@yopmail.com");
        email.add("ogeddidottu-3567@yopmail.com");
        email.add("umevynnux-3141@yopmail.com");
        email.add("manumuny-1343@yopmail.com");
        email.add("iffonunnuff-9372@yopmail.com");
        email.add("pussolazo-6879@yopmail.com");
        email.add("uzolesso-9700@yopmail.com");
        
        adress.add("7621 Adams Street" +
" Carlisle, PA 17013");
        adress.add("7126 Homestead Ave." +
" Olympia, WA 98512");
        adress.add("799 Talbot Lane" +
" Loxahatchee, FL 33470");
        adress.add("35 Glendale Ave." +
" Middle River, MD 21220");
        adress.add("7789 Campfire Drive" +
" Willingboro, NJ 08046");
        adress.add("8033 Franklin Court" +
" Latrobe, PA 15650");
        adress.add("527 East Edgewater Avenue" +
" Bellmore, NY 11710");
        adress.add("65 Gregory St." +
" La Crosse, WI 54601");
        adress.add("942 Rockcrest Dr." +
" Egg Harbor Township, NJ 08234");
        adress.add("88 Devon Street" +
" Fond Du Lac, WI 54935");
        adress.add("408 Canterbury Ave." +
" Jonesboro, GA 30236");
        adress.add("7360 Riverside Ave." +
" Saratoga Springs, NY 12866");
        adress.add("112 Snake Hill Drive" +
" Salt Lake City, UT 84119");
        adress.add("975 Tower St." +
" Portland, ME 04103");
        
        bank.add("PL367708515942301076464603666379");
        bank.add("PL351053865678918988125398301616");
        bank.add("PL703286368257500595859873195842");
        bank.add("PL969622099991233222767385749071");
        bank.add("PL526051338483269619611791933858");
        bank.add("PL835080503309917101076250760754");
        bank.add("PL840284055256500415685904529926");
        bank.add("PL942985863345962962741208430120");
        bank.add("PL836182379034603886641026533851");
        bank.add("PL295821556689940362336906418695");
        bank.add("PL909996533021216600087730833569");
        bank.add("PL549652194022670587458987514583");
        bank.add("PL699793891237058017741642863204");
        bank.add("PL589045916236112508579530158788");
        
        REGON.add("29387744068403");
        REGON.add("17468849341341");
        REGON.add("05297660529014");
        REGON.add("11890207998446");
        REGON.add("83136645615750");
        REGON.add("73110321130795");
        REGON.add("91824670465710");
        REGON.add("15919102828004");
        REGON.add("67503893683530");
        REGON.add("09184822229941");
        REGON.add("77298364881760");
        
        
        
        
        
        
    }

    /**
     * @return the names
     */
    public ArrayList<String> getNames()
    {
        return names;
    }

    /**
     * @return the surnames
     */
    public ArrayList<String> getSurnames()
    {
        return surnames;
    }

    /**
     * @return the PESELs
     */
    public ArrayList<String> getPESELs()
    {
        return PESELs;
    }

    /**
     * @return the registrationNumbers
     */
    public ArrayList<String> getRegistrationNumbers()
    {
        return registrationNumbers;
    }

    /**
     * @return the phone
     */
    public ArrayList<String> getPhone()
    {
        return phone;
    }

    /**
     * @return the email
     */
    public ArrayList<String> getEmail()
    {
        return email;
    }

    /**
     * @return the adress
     */
    public ArrayList<String> getAdress()
    {
        return adress;
    }

    /**
     * @return the bank
     */
    public ArrayList<String> getBank()
    {
        return bank;
    }

    /**
     * @return the REGON
     */
    public ArrayList<String> getREGON()
    {
        return REGON;
    }
}
