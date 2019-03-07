### SpringBoot 全局异常统一处理


- 业务逻辑异常

    ```java
       throw new BusinessException("具体异常信息");
       在逻辑出现问题时就可以直接将该异常抛出来 就会被 GlobalExceptionHandler.java 捕获到 并返回json格式的错误信息
     
       http://localhost:8080/business
     
          {
              "code": 101,
              "msg": "参数不能为空",
              "url": "http://localhost:8080/business",
              "data": "this is some data"
          }
     
    ```
    
- 系统异常
    
    ```java
     系统所有运行时发生异常都能被 GlobalExceptionHandler.java 捕获到 并返回json格式的错误信息
     该错误信息就是系统定义好了的啦 例如: / by zero 空指针   数组下标越界等
      
     http://localhost:8080/system
     
       {
           "code": 100,
           "msg": "/ by zero",
           "url": "http://localhost:8080/system",
           "data": "this is some data"
       }
        
    ```