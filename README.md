# mizu-selenium-java

Testleri JDK ve Maven kurulu ortamda aşağıdaki şekilde çalıştırabilirsiniz.

Default ayarlarla testleri çalıştırmak için -> ``mvn clean test``

Testleri koşmak istediğiniz browser 'ı seçebilirsiniz -> ``mvn clean test -Dbrowser=firefox``

Testleri headless modda koşabilirsiniz -> ``mvn clean test -Dbrowser=chrome -Dheadless=true``

Testleri paralel koşabilirsiniz -> ``mvn clean test -Dparallel="methods"``