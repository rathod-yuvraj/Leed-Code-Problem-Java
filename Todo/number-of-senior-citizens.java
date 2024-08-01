class Solution {
    public int countSeniors(String[] details) {

        int c=0;
        for(int i=0;i<details.length;i++)
        {
         String str=details[i].substring(11,13);
         int age=Integer.parseInt(str);
          if(age>60)
          {
            c++;
          }
        }
        return c;
        
    }
}
