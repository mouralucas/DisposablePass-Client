/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disposablePasswd;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Lucas
 */
public class HashGenerator {

    List<String> hashList = new ArrayList<>();
    Hash hash = new Hash();

    //gera uma lista com 20 hashs a partir de uma senha
    public List listGenerator(String passwd) {
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        
        hashList.add(String.valueOf(minute));//posição 0 do vetor é o minuto em que foi criado
        hashList.add(hash.pass2hash(passwd+minute));
        for (int i = 0; i < 20; i++) {
            hashList.add(hash.pass2hash(hashList.get(i)));
        }
        
        System.out.println("Tamanho da lista de hash - server: " + hashList.size());
        return hashList;
    }
}
