package strsearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author regesober
 */
public class Test {

    public static void main(String[] args) {
        String p = buildString(1000000, "41uiweh12frqwjrfwoie"); // Tamanho 20*1.000.000 = 20 M chars
        String t = buildString(20000000, "b"); // Tamanho 20.000.000*1 = 20 M chars
        char[] pattern = p.toCharArray();
        char[] text = t.toCharArray();
        long a = System.nanoTime();
        StringSearchAlgorithms.RabinKarpMethod(pattern, text);
        a = System.nanoTime() - a;
        System.out.println("RabinKarp: " + a/1000 + " us");
        a = System.nanoTime();
        StringSearchAlgorithms.KnuthMorrisPrattSearch(pattern, text);
        a = System.nanoTime() - a;
        System.out.println("KnuthMorrisPratt: " + a/1000 + " us");
        a = System.nanoTime();
        StringSearchAlgorithms.BoyerMooreHorspoolSearch(pattern, text);
        a = System.nanoTime() - a;
        System.out.println("BoyerMooreHorspool: " + a/1000 + " us");
    }

    public static final String buildString(int length, String c) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            sb.append(c);
        }
        return sb.toString();
    }

}
