package com.rw.quickcare.validation;

import javax.validation.groups.Default;

/**
 * @program: quickcare
 * @InterfaceName ValidGroup
 * @description:
 * @author: LRW
 * @create: 2024-02-27 13:19
 * @Version 1.0
 **/
public interface ValidGroup extends Default {
    interface Crud extends ValidGroup{
        interface Create extends Crud{

        }
        interface Update extends Crud{

        }
        interface Query extends Crud{

        }
        interface Delete extends Crud{

        }

    }

}
