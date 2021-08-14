package com.lessons.interfaces;

public class _16_WhatsInAName {

    /*
     - Interface naming
        - Interfaces usually represent some characteristic or nature
            - e.g. Cat could be a nature
            - e.g. RequiresAuth is a characteristic
        - You may see names such as:
            - IsA
            - Can
            - Has/Having
            - Requires/Requiring/Must
            - ...able
        - Sometimes you see prefixes like 'I'
            - e.g. ICat
            - Best to avoid as
                - its a Hungarian notation
                - is there any value in making that distinction?
                    - it clutters the code
                    - clients often wont care
                    - ides will tell you anyway

    */
    interface IHavingRequiringCanMustShouldDoesBlahBlah { }

    /*
     - Default methods
        - default methods are sometimes called:
            - 'Defender' methods
            - or
            - 'Virtual extension' methods
            - ...but you rarely see them referred to as this
    */

}
