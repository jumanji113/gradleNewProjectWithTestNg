package config;

import org.aeonbits.owner.Config;  // Импорт основной аннотации Owner для создания прокси-интерфейса

/**
 * Интерфейс для чтения конфигураций API.
 * Owner автоматически загружает значения из config.properties.
 * Каждый метод соответствует ключу в файле — Owner подставляет значение при вызове.
 * Если ключ не найден, метод вернёт null или default-значение (если указано с @DefaultValue).
 * Это следует DRY: конфиги в одном месте, используются везде без дублирования.
 */
@Config.Sources("classpath:config.properties")  // Указываем источник: файл в classpath (src/test/resources). Owner ищет его автоматически.
public interface ApiConfig extends Config {  // Наследуем от Config, чтобы Owner сгенерировал реализацию интерфейса на лету.

    @Key("base.url")  // Аннотация сопоставляет метод с ключом в properties. Owner ищет точно "base.url".
    String baseUrl();  // Метод возвращает строку. Owner берёт значение из файла и возвращает его. Если ключа нет — null.

    @Key("timeout")  // Ещё один ключ. Owner конвертирует строку в int автоматически.
    @DefaultValue("1")  // Default-значение, если ключ не найден в файле. Это предотвращает NPE и следует KISS.
    int timeout();  // Возвращает int. Если значение в файле не число — Owner бросит исключение (early fail).

    @Key("log.level")  // Ключ для уровня логирования.
    String logLevel();  // Без default — вернёт null, если не найден. Добавь проверку в коде, чтобы избежать ошибок.
}
