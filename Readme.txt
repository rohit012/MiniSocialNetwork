Just run all test cases in Source/test/java2014-09-30 21:26:27 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:27 INFO  XmlBeanDefinitionReader:315 - Loading XML bean definitions from URL [file:src/main/resources/bean-config.xml]
2014-09-30 21:26:27 INFO  GenericApplicationContext:510 - Refreshing org.springframework.context.support.GenericApplicationContext@4e3e95e6: startup date [Tue Sep 30 21:26:27 PDT 2014]; root of context hierarchy
2014-09-30 21:26:27 INFO  DefaultListableBeanFactory:596 - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@3514a9dc: defining beans [org.springframework.aop.config.internalAutoProxyCreator,profileServiceImpl,validations,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor]; root of factory hierarchy
2014-09-30 21:26:28 INFO  ValidationTest:58 - <<----------------------------Test A ---------------------------->>
2014-09-30 21:26:28 INFO  ValidationTest:60 - <<--------------------------Bob trying to access Alice Profile------------>> 
2014-09-30 21:26:28 INFO  ProfileServiceImpl:48 - Access denied
2014-09-30 21:26:28 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:28 INFO  ValidationTest:74 - <<----------------------------Test B ---------------------------->>
2014-09-30 21:26:28 INFO  ValidationTest:75 - <<---Alice shares her profile with Bob, and Bob can read Alice’s profile------->> 
2014-09-30 21:26:28 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:28 INFO  ValidationTest:87 - <<----------------------------Test C ---------------------------->>
2014-09-30 21:26:28 INFO  ValidationTest:90 - <<---Alice shares her profile with Bob, and Bob shares Alice’s profile with Carl, and Carl can ready Alice’s profile------->> 
2014-09-30 21:26:28 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:28 INFO  ValidationTest:106 - <<----------------------------Test D ---------------------------->>
2014-09-30 21:26:28 INFO  ProfileServiceImpl:108 - Access denied
2014-09-30 21:26:28 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:28 INFO  ValidationTest:118 - <<----------------------------Test E ---------------------------->>
2014-09-30 21:26:28 INFO  ValidationTest:121 - Alice shared his profile with Bob
2014-09-30 21:26:28 INFO  ValidationTest:124 - Bob shared Alice profile with Carl 
2014-09-30 21:26:28 INFO  ValidationTest:127 - Alice unshares with carl
2014-09-30 21:26:28 INFO  ProfileServiceImpl:48 - Access denied
2014-09-30 21:26:28 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:28 INFO  ValidationTest:141 - <<----------------------------Test F ---------------------------->>
2014-09-30 21:26:28 INFO  ValidationTest:145 - Alice shared his profile with Bob
2014-09-30 21:26:28 INFO  ValidationTest:148 - Alice shared his profile with Carl
2014-09-30 21:26:28 INFO  ValidationTest:151 - Carl shared Alice profile with Bob
2014-09-30 21:26:28 INFO  ValidationTest:154 - Alice unshared his profile with Bob
2014-09-30 21:26:28 INFO  ProfileServiceImpl:48 - Access denied
2014-09-30 21:26:28 INFO  ValidationTest:36 - hello logger
2014-09-30 21:26:28 INFO  ValidationTest:171 - <<-------------------------Test G------------->>
2014-09-30 21:26:28 INFO  ValidationTest:174 - Alice shared his profile with Bob
2014-09-30 21:26:28 INFO  ValidationTest:177 - Bob shared Alice profile with Carl
2014-09-30 21:26:28 INFO  ValidationTest:184 -  read profile successful of Alice with username Alice
2014-09-30 21:26:28 INFO  ProfileServiceImpl:48 - Access denied
2014-09-30 21:26:28 INFO  GenericApplicationContext:1042 - Closing org.springframework.context.support.GenericApplicationContext@4e3e95e6: startup date [Tue Sep 30 21:26:27 PDT 2014]; root of context hierarchy
2014-09-30 21:26:28 INFO  DefaultListableBeanFactory:444 - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@3514a9dc: defining beans [org.springframework.aop.config.internalAutoProxyCreator,profileServiceImpl,validations,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor]; root of factory hierarchy
 
 
 
 TEST A:pass
 TEST B:pass
 TEST C:pass
 TEST D:pass
 TEST E:pass
 TEST F:pass
 TEST G:pass
 