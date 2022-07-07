public class reverse_polish {
    public static void main(String[] args){
        Stack rpn = new Stack();
        String op = "";
        int result = 0;
        //sample equation: 4 5 + 4 5 + +
        String equation = "4 5 + 4 5 + + 2 4 5 6 + / + *";
        String[] equationBetter = equation.split(" ");

        for (int i=0; i<equationBetter.length; i++){
            op = equationBetter[i];
            if(op.equals("+")){

                result = rpn.pop()+rpn.pop();
                rpn.push(result);
            }
            else if(op.equals("-")){
                int val1 = rpn.pop();
                int val2 = rpn.pop();
                result = val2-val1;
                rpn.push(result);
            }
            else if(op.equals("*")){

                result = rpn.pop()*rpn.pop();
                rpn.push(result);
            }
            else if(op.equals("/")){
                int val1 = rpn.pop();
                int val2 = rpn.pop();
                result = val2/val1;
                rpn.push(result);
            }
            else{
                rpn.push(Integer.parseInt(op));
            }
        }
        System.out.println(rpn.peek());
    }
}
