package com.dhn.javabasis.exception;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/31 11:47
 */
public class ThrowTest {
    public static void main(String[] args) {
        try{
            //调用checked异常的方法，要么显示捕获,要么在main中再次throws
            throwChecked(-3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //既可以显示捕获、也可以不理会
        throwRuntime(3);
    }

    private static void throwRuntime(int a) {
        if (a > 0){
            //自行抛出RuntimeException异常，既可以显示捕获1也可以不理会，把异常交给方法调用者处理
            throw new RuntimeException("a大于0，不符合要求");
        }
    }

    private static void throwChecked(int a) throws Exception {
        if (a > 0){
            //自行抛出Exception异常,该方法必须位于try、catch代码块或处于throws声明的方法里
            throw new Exception("a大于0，不符合要求");
        }
    }
}
