junit4的使用

shift + Ctrl + t 生成

@Test:每一个测试单元，一定要加上@Test注解

@Before:在测试单元执行前执行，通常用来初始化数据

@After:在测试单元执行后执行,用来输出结果等

junit不是用来证明你是对的  而是用来证明你没有错

@Before 每个测试方法执行前都会执行一次。

@After 每个测试方法执行后都会执行一次。

@BeforeClass 在所有方法调用前调用 (多数用于资源操作)

@AfterClass 在所有方法调用后调用(多数用于资源操作)

@Test(expected =Exception.class ) 爆出指定的预期异常 测试通过  否则测试失败

@Test(timeout = 100) 运行的代码超过指定时间 则结束 单位是毫秒

@Ignore 忽略当前junit中的指定方法 意思就是该方法为未完成的方法

@RunWith 修改测试运行器  需要你自己拟定的测试器继承org.junit.runner.Runner即可

断言：assert 