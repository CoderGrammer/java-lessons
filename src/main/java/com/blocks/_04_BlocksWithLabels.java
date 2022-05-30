package com.blocks;

/*
 - You can give them labels
    - This is useful if you want to break out of a block
*/
public class _04_BlocksWithLabels {

    public static void main(String[] args) {
        System.out.println("Before block");
        blah : {
            System.out.println("blah");
            if (1 == 1) {
                break blah;
            }
            System.out.println("foo");
        }
        System.out.println("Do some other stuff");
    }
    // Personally I would probably move this to a private method, but
    // you do have this option

    // You cannot have labels at the instance level
    // foo : {
    //     System.out.println("something repetitive");
    // }

    // But  you can inside an instance block
    {
        foo : {
            System.out.println("something repetitive");
        }
    }

}
