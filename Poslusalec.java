import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Poslusalec implements ActionListener {

    static ArrayList infix = new ArrayList();






    public void actionPerformed (ActionEvent e){

        for (int i = 0; i < GUI.buttonText.length; i++) {
            for (int j = 0; j < GUI.buttonText[0].length; j++) {
                if (GUI.button[i][j] == e.getSource()) {
                    if (Evaluator.isNumber(GUI.button[i][j].getText())){
                        GUI.field.setText(GUI.field.getText().concat(GUI.button[i][j].getText()));


                    }else if(GUI.buttonText[i][j] == "."){
                        GUI.field.setText(GUI.field.getText().concat(GUI.button[i][j].getText()));

                    }else if(GUI.buttonText[i][j] == "±"){
                        try {
                            String trenutniTxt = GUI.field.getText();
                            if(Double.parseDouble(trenutniTxt) > 0){
                                GUI.field.setText("-".concat(trenutniTxt));
                            }else if(Double.parseDouble(trenutniTxt) < 0){
                                GUI.field.setText(String.valueOf((-1 * Double.parseDouble(trenutniTxt))));
                            }
                        }catch (Exception ex){

                        }

                    }else if(GUI.buttonText[i][j] == "√x"){
                        if(Evaluator.isNumber(GUI.field.getText())){
                            GUI.field.setText(String.valueOf(Math.sqrt(Double.parseDouble(GUI.field.getText()))));
                        }


                    }else if(GUI.buttonText[i][j] == "x^2"){
                        if(Evaluator.isNumber(GUI.field.getText())){
                            GUI.field.setText(String.valueOf(Math.pow(Double.parseDouble(GUI.field.getText()), 2)));
                        }

                    }else if(GUI.buttonText[i][j] == "c"){
                        GUI.field.setText("");
                        GUI.label.setText("");
                        infix.clear();

                    }else if(GUI.buttonText[i][j] == "⌫"){
                        GUI.field.setText(GUI.field.getText().replaceFirst(".$",""));

                    }else if(GUI.buttonText[i][j] == "(") {
                        GUI.field.setText(GUI.field.getText().concat("("));

                    }else if(GUI.buttonText[i][j] == ")") {
                        GUI.field.setText(GUI.field.getText().concat(")"));

                    }else if(GUI.buttonText[i][j] == "%"){
                        GUI.field.setText(GUI.field.getText().concat("%"));

                    }else if(GUI.buttonText[i][j] == "/"){
                        GUI.field.setText(GUI.field.getText().concat("/"));

                    }else if(GUI.buttonText[i][j] == "*"){
                        GUI.field.setText(GUI.field.getText().concat("*"));

                    }else if(GUI.buttonText[i][j] == "-"){
                        GUI.field.setText(GUI.field.getText().concat("-"));

                    }else if(GUI.buttonText[i][j] == "+"){
                        GUI.field.setText(GUI.field.getText().concat("+"));

                    }else if(GUI.buttonText[i][j] == "="){
                        if(!GUI.field.getText().isEmpty()){
                            GUI.label.setText(GUI.field.getText());
                            Splitter();
                            Evaluate();
                        }
                    }
                }
            }
        }
    }




    static void Evaluate(){
        ArrayList list = new ArrayList(Evaluator.convertInfixToRPN(infix));
        System.out.println(list);
        try{
            double result = Evaluator.evalRPN(list);
            System.out.println(result);
            GUI.field.setText(String.valueOf(result));

        }catch (Exception e){
            GUI.label.setText("Wrong input!");
        }
        infix.clear();
    }

    static void Splitter(){
        String niz = GUI.field.getText();
        String num = "";
        for (int i = 0; i < niz.length(); i++) {
            if('.' == niz.charAt(i) || Evaluator.isNumber(String.valueOf(niz.charAt(i))) || (i==0 && niz.charAt(0)=='-')){
                num = num.concat(String.valueOf(niz.charAt(i)));
            }else{
                System.out.println(num);
                if(num != ""){
                    infix.add(num);
                }
                num = "";
                infix.add(String.valueOf(niz.charAt(i)));
            }
        }
        if(Evaluator.isNumber(num)){
            infix.add(num);
        }
        System.out.println(infix);
    }


}
