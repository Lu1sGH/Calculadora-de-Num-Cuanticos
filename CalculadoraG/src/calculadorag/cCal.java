package calculadorag;

import javax.swing.JOptionPane;

public class cCal {
    private String elemento;
    private int electrones;
    private int periodo;
    private String configuracionE;
    private int n = 0;
    private int l = 0;
    private int m = 0;
    private String spin = "";

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public void setElectrones(int electrones) {
        this.electrones = electrones;
    }

    public int getPeriodo() {
        return periodo;
    }

    public String getConfiguracionE() {
        return configuracionE;
    }

    public int getN() {
        return n;
    }

    public int getL() {
        return l;
    }

    public int getM() {
        return m;
    }

    public String getSpin() {
        return spin;
    }

    public void datos(){
        //Evaluar al periodo al que pertenece
        if(electrones>118){
            JOptionPane.showMessageDialog(null, "Aún no existen elementos con "+electrones+" electrones.");
        }
        else{
            if(electrones<1){
                JOptionPane.showMessageDialog(null, "Número de electrones inválido.");
            }
            else{
                if(electrones>=87 && electrones<=118){
                    periodo = 7;
                }
                else{
                    if(electrones>=55 && electrones<=86){
                        periodo = 6;
                    }
                    else{
                        if(electrones>=37 && electrones<=54){
                            periodo = 5;
                        }
                        else{
                            if(electrones>=19 && electrones<=36){
                                periodo = 4;
                            }
                            else{
                                if(electrones>=11 && electrones<=18){
                                    periodo = 3;
                                }
                                else{
                                    if(electrones>=3 && electrones <=10){
                                        periodo = 2;
                                    }
                                    else{
                                        periodo = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void Calcular(){
        boolean sobrantes = true;   //evaluar si hay electrones sobrantes
        int diferencial = 0;        //ayuda a evaluar electron diferencial
        int momento = 0;            //ayuda a evaluar momento angular
        int s = 0;                  //subnivel s
        int p = 0;                  //subnivel p
        int d = 0;                  //subnivel d
        int f = 0;                  //subnivel f
        
        //Calcular No. Cuánticos en base al periodo
        switch(periodo){
            //PERIODO 1
            case 1:
                diferencial = electrones;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 1;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                l = n - 1;
                m = 0;
                if(s==1){
                    spin = "+1/2";
                }
                else{
                    spin = "-1/2";
                }
                
                configuracionE = "1s"+s;
                break;
                
            //PERIODO 2    
            case 2:
                diferencial = electrones-2;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 2;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                if (diferencial>0){
                    for (int i = 1; i <= 6; i++) { //evaluar subnivel p
                        diferencial = diferencial-1;
                        if (diferencial == 0){
                            p = i;
                            n = 2;
                            l = 1;
                            break;
                        }
                        else{
                            p = i;
                        }
                    }
                }
                
                momento = p; //evalua momento
                if (p > 0){
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -1; j <= 1; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if(p>0){ //Evaluar spin
                    if(p > 3){
                        spin = "-1/2";
                    }
                    else{
                        spin = "+1/2";
                    }
                }
                else{
                    if(s==1){
                        spin = "+1/2";
                    }
                    else{
                        spin = "-1/2";
                    }
                }
                configuracionE = "[He]2s"+s+" ";
                if (p > 0) {
                    configuracionE = "[He]2s"+s+" "+"2p"+p;
                }
                break;
                
            //PERIODO 3
            case 3:
                diferencial = electrones-10;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 3;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                if (diferencial>0){
                    for (int i = 1; i <= 6; i++) { //evaluar subnivel p
                        diferencial = diferencial-1;
                        if (diferencial == 0){
                            p = i;
                            n = 3;
                            l = 1;
                            break;
                        }
                        else{
                            p = i;
                        }
                    }
                }
                momento = p; //evalua momento
                if (p>0){
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -1; j <= 1; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                if(p>0){ //Evaluar spin
                    if(p > 3){
                        spin = "-1/2";
                    }
                    else{
                        spin = "+1/2";
                    }
                }
                else{
                    if(s==1){
                        spin = "+1/2";
                    }
                    else{
                        spin = "-1/2";
                    }
                }
                configuracionE = "[Ne]3s"+s+" ";
                if (p > 0) {
                    configuracionE = "[Ne]3s"+s+" "+"3p"+p;
                }
                break;
                
            //PERIODO 4
            case 4:
                diferencial = electrones - 18;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 4;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                if (diferencial>0){ //evaluar subnivel d
                    for (int i = 1; i <= 10; i++) {
                        diferencial = diferencial-1;
                        if(diferencial == 0){
                            d = i;
                            n = 3;
                            l = 2;
                            break;
                        }
                        else{
                            d = i;
                        }
                    }
                }
                if (diferencial>0){
                    for (int i = 1; i <= 6; i++) { //evaluar subnivel p
                        diferencial = diferencial-1;
                        if (diferencial == 0){
                            p = i;
                            n = 4;
                            l = 1;
                            break;
                        }
                        else{
                            p = i;
                        }
                    }
                }
                
                //evalua momento
                if (d>0){
                    momento = d;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -2; j <= 2; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if (p>0){
                    sobrantes = true;
                    m = 0;
                    momento = p;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -1; j <= 1; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if(p>0){ //Evaluar spin
                    if(p > 3){
                        spin = "-1/2";
                    }
                    else{
                        spin = "+1/2";
                    }
                }
                else{
                    if(d>0){
                        if(d>5){
                            spin = "-1/2";
                        }
                        else{
                            spin = "+1/2";
                        }
                    }
                    else{
                        if(s==1){
                            spin = "+1/2";
                        }
                        else{
                            spin = "-1/2";
                        }
                    }
                }
                
                configuracionE = "[Ar]4s"+s+" ";
                if(d>0){
                    configuracionE = "[Ar]4s"+s+" "+"3d"+d+" ";
                }
                if(p>0){
                    configuracionE = "[Ar]4s"+s+" "+"3d"+d+" "+"4p"+p;
                }
                break;
                
            //PERIODO 5
            case 5:
                diferencial = electrones - 36;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 5;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                if (diferencial>0){ //evaluar subnivel d
                    for (int i = 1; i <= 10; i++) {
                        diferencial = diferencial-1;
                        if(diferencial == 0){
                            d = i;
                            n = 4;
                            l = 2;
                            break;
                        }
                        else{
                            d = i;
                        }
                    }
                }
                if (diferencial>0){
                    for (int i = 1; i <= 6; i++) { //evaluar subnivel p
                        diferencial = diferencial-1;
                        if (diferencial == 0){
                            p = i;
                            n = 5;
                            l = 1;
                            break;
                        }
                        else{
                            p = i;
                        }
                    }
                }
                
                //evalua momento
                if (d>0){
                    momento = d;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -2; j <= 2; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if (p>0){
                    sobrantes = true;
                    m = 0;
                    momento = p;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -1; j <= 1; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if(p>0){ //Evaluar spin
                    if(p > 3){
                        spin = "-1/2";
                    }
                    else{
                        spin = "+1/2";
                    }
                }
                else{
                    if(d>0){
                        if(d>5){
                            spin = "-1/2";
                        }
                        else{
                            spin = "+1/2";
                        }
                    }
                    else{
                        if(s==1){
                            spin = "+1/2";
                        }
                        else{
                            spin = "-1/2";
                        }
                    }
                }
                
                configuracionE = "[Kr]5s"+s+" ";
                if(d>0){
                    configuracionE = "[Kr]5s"+s+" "+"4d"+d+" ";
                }
                if(p>0){
                    configuracionE = "[Kr]5s"+s+" "+"4d"+d+" "+"5p"+p;
                }
                break;
                
            //PERIODO 6
            case 6:
                diferencial = electrones - 54;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 6;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                if (diferencial>0){ //evaluar f
                    for (int i = 1; i <= 14; i++) {
                        diferencial = diferencial-1;
                        if(diferencial == 0){
                            f = i;
                            n = 4;
                            l = 3;
                            break;
                        }
                        else{
                            f = i;
                        }
                    }
                }
                if (diferencial>0){ //evaluar subnivel d
                    for (int i = 1; i <= 10; i++) {
                        diferencial = diferencial-1;
                        if(diferencial == 0){
                            d = i;
                            n = 5;
                            l = 2;
                            break;
                        }
                        else{
                            d = i;
                        }
                    }
                }
                if (diferencial>0){
                    for (int i = 1; i <= 6; i++) { //evaluar subnivel p
                        diferencial = diferencial-1;
                        if (diferencial == 0){
                            p = i;
                            n = 6;
                            l = 1;
                            break;
                        }
                        else{
                            p = i;
                        }
                    }
                }
                
                //evalua momento
                if(f>0){
                    momento = f;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -3; j <= 3; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if (d>0){
                    sobrantes = true;
                    m = 0;
                    momento = d;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -2; j <= 2; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if (p>0){
                    sobrantes = true;
                    m = 0;
                    momento = p;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -1; j <= 1; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if(p>0){ //Evaluar spin
                    if(p > 3){
                        spin = "-1/2";
                    }
                    else{
                        spin = "+1/2";
                    }
                }
                else{
                    if(d>0){
                        if(d>5){
                            spin = "-1/2";
                        }
                        else{
                            spin = "+1/2";
                        }
                    }
                    else{
                        if(f>0){
                            if(f>7){
                            spin = "-1/2";
                            }
                            else{
                            spin = "+1/2";
                            }
                        }
                        else{
                            if(s==1){
                                spin = "+1/2";
                            }
                            else{
                                spin = "-1/2";
                            }
                        }
                    }
                }
                
                configuracionE = "[Xe]6s"+s+" ";
                if(f>0){
                    configuracionE = "[Xe]6s"+s+" "+"4f"+f+" ";
                }
                if(d>0){
                    configuracionE = "[Xe]6s"+s+" "+"4f"+f+" "+"5d"+d+" ";
                }
                if(p>0){
                    configuracionE = "[Xe]6s"+s+" "+"4f"+f+" "+"5d"+d+" "+"6p"+p;
                }
                break;
                
            //PERIODO 7
            case 7:
                diferencial = electrones - 86;
                for (int i = 1; i <= 2; i++) { //evaluar subnivel s
                    diferencial = diferencial-1;
                    if (diferencial == 0) {
                        s = i;
                        n = 7;
                        l = 0;
                        break;
                    }
                    else{
                        s = i;
                    }
                }
                if (diferencial>0){ //evaluar f
                    for (int i = 1; i <= 14; i++) {
                        diferencial = diferencial-1;
                        if(diferencial == 0){
                            f = i;
                            n = 5;
                            l = 3;
                            break;
                        }
                        else{
                            f = i;
                        }
                    }
                }
                if (diferencial>0){ //evaluar subnivel d
                    for (int i = 1; i <= 10; i++) {
                        diferencial = diferencial-1;
                        if(diferencial == 0){
                            d = i;
                            n = 6;
                            l = 2;
                            break;
                        }
                        else{
                            d = i;
                        }
                    }
                }
                if (diferencial>0){
                    for (int i = 1; i <= 6; i++) { //evaluar subnivel p
                        diferencial = diferencial-1;
                        if (diferencial == 0){
                            p = i;
                            n = 7;
                            l = 1;
                            break;
                        }
                        else{
                            p = i;
                        }
                    }
                }
                
                //evalua momento
                if(f>0){
                    momento = f;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -3; j <= 3; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if (d>0){
                    sobrantes = true;
                    m = 0;
                    momento = d;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -2; j <= 2; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if (p>0){
                    sobrantes = true;
                    m = 0;
                    momento = p;
                    for (int i = 1; i <= 2; i++) {
                        if(sobrantes==false){
                            break;
                        }
                        else{
                            for (int j = -1; j <= 1; j++){
                                momento = momento-1;
                                if (momento <= 0){
                                    m = j;
                                    sobrantes = false;
                                    break;
                                }
                                else{
                                    m = j;
                                }
                            }
                        }
                    }
                }
                
                if(p>0){ //Evaluar spin
                    if(p > 3){
                        spin = "-1/2";
                    }
                    else{
                        spin = "+1/2";
                    }
                }
                else{
                    if(d>0){
                        if(d>5){
                            spin = "-1/2";
                        }
                        else{
                            spin = "+1/2";
                        }
                    }
                    else{
                        if(f>0){
                            if(f>7){
                            spin = "-1/2";
                            }
                            else{
                            spin = "+1/2";
                            }
                        }
                        else{
                            if(s==1){
                                spin = "+1/2";
                            }
                            else{
                                spin = "-1/2";
                            }
                        }
                    }
                }
                configuracionE = "[Rn]7s"+s+" ";
                if(f>0){
                    configuracionE = "[Rn]7s"+s+" "+"5f"+f+" ";
                }
                if(d>0){
                    configuracionE = "[Rn]7s"+s+" "+"5f"+f+" "+"6d"+d+" ";
                }
                if(p>0){
                    configuracionE = "[Rn]7s"+s+" "+"5f"+f+" "+"6d"+d+" "+"7p"+p;
                }
                break;
                
            default:
                break;
        }
    }
    
    public void rCuestionario(int prin, int sec, int angular, String s){
        int rN = prin;
        int rL = sec;
        int rMl = angular;
        String rMs = s;
        if(rN == n && rL == l && rMl == m && rMs.equalsIgnoreCase(spin)){
            JOptionPane.showMessageDialog(null, "Todos los datos ingresados son correctos, ¡Muy bien!");
        }
        else{
            if (rN != n) {
                JOptionPane.showMessageDialog(null, "El valor que usted ingresó para n es incorrecto.");
                if (rL != l) {
                    JOptionPane.showMessageDialog(null, "El valor que usted ingresó para l es incorrecto.");
                    if (rMl != m) {
                        JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ml es incorrecto.");
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                    else{
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                }
                else{
                    if (rMl != m) {
                        JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ml es incorrecto.");
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                    else{
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                }
            }
            else{
                if (rL != l) {
                    JOptionPane.showMessageDialog(null, "El valor que usted ingresó para l es incorrecto.");
                    if (rMl != m) {
                        JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ml es incorrecto.");
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                    else{
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                }
                else{
                    if (rMl != m) {
                        JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ml es incorrecto.");
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                    else{
                        if (!rMs.equals(spin)) {
                            JOptionPane.showMessageDialog(null, "El valor que usted ingresó para ms es incorrecto.");
                        }
                    }
                }
            }
        }
    }
}

// ||¬'2