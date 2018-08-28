public class FibonacciSequence(){

//使用递归的方式实现斐波那契数列

    public static void feibo{
        int num1=1;
        int num2=1;
        int num3=0;
        System.out.println(num1);
        System.out.println(num2);
        for(int i=1;i< 10;i++){
        num3=num1+num2;
        num1=num2;
        num2=num3;
        System.out.println(num3);
        }
        }




    public static void int f(int n){
        if(n == 0){
            throw new Exception("参数错误");
        }
    if(n == 1 || n == 2){
        return 1;
        }else{
            return f(n-1) + f(n-2)
        }

        }

    private static void f(int x){
        int f1=1,f2=1,i=3;
        if(x==1)System.out.print(f1);
        if(x==2)System.out.print(f1+"  "+f2);
        if(x>=3){                 //求位置大于三的数列
        System.out.print(f1+"  "+f2);
        while(x>=i){         //求数列
        f1=f2+f1;        //求两项之和
        System.out.print("  "+f1);
        i++;
        f2=f2+f1;
        System.out.print("  "+f2);
        }
        }
        }
public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入你想查看的斐波那契数列个数：");
        int num=s.nextInt();
        System.out.println("你想看的斐波那契数列：");
        f(num/2+1);
        }