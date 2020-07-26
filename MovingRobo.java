class Test{
    public static String Solution(String input1,String input2,String input3,String input4){
        int gridx = Integer.parseInt(input1);
        int gridy = Integer.parseInt(input2);
        //------------------------------------
        String coord[] = input3.split("-");
        String dir[] = input4.split(" ");
        //-----------------------------------
        int myx = Integer.parseInt(coord[0]);
        int myy = Integer.parseInt(coord[1]);
        String mydir = coord[2];
        
        //------------------------------------
        boolean breaker = false;
        for(int i=0;i<dir.length;i++){
            if(dir[i].equals("M")){
                if(mydir.equals("N")){
                    myy++;
                    if(myy>gridy){
                        myy--;
                        breaker= true;
                        break;
                    }
                }
                if(mydir.equals("S")){
                    myy--;
                    if(myy<0){
                        myy++;
                        breaker= true;
                        break;
                    }
                }
                if(mydir.equals("E")){
                    myx++;
                    if(myx>gridx){
                        myx--;
                        breaker= true;
                        break;
                    }
                }
                if(mydir.equals("W")){
                    myx--;
                    if(myx<0){
                        myx++;
                        breaker= true;
                        break;
                    }
                }
            }
            else{
               //N-R-E, N-L-W,E-L-N,E-R-S,W-L-S,W-R-N,S-L-E,S-R-W
               if(mydir.equals("N") && dir[i].equals("R")){
                   mydir = "E";
                   continue;
               }
               if(mydir.equals("N") && dir[i].equals("L")){
                mydir = "W";
                continue;
                }
                if(mydir.equals("S") && dir[i].equals("R")){
                    mydir = "W";
                    continue;
                }
                if(mydir.equals("S") && dir[i].equals("L")){
                    mydir = "E";
                    continue;
                }
                if(mydir.equals("E") && dir[i].equals("L")){
                    mydir = "N";
                    continue;
                }
                if(mydir.equals("E") && dir[i].equals("R")){
                    mydir = "S";
                    continue;
                }
                if(mydir.equals("W") && dir[i].equals("L")){
                    mydir = "S";
                    continue;
                }
                if(mydir.equals("W") && dir[i].equals("R")){
                    mydir = "N";
                    continue;
                }
            }
        }

        //--------------------------------------
        String er = "";
        if(breaker==true){
            er = "-ER";
        }
        String op = myx+"-"+myy+"-"+mydir+er;
        return op;
    }
    public static void main(String[] args) {
        System.out.println(Solution("3","4","2-2-E","R M L M L M R M"));
    }
}