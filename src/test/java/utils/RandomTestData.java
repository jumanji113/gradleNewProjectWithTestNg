package utils;

import com.github.javafaker.Faker;
import models.request.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTestData {

    // ThreadLocal для Faker - каждый поток имеет свой экземпляр
    private static final ThreadLocal<Faker> FAKER_THREAD_LOCAL =
            ThreadLocal.withInitial(() -> new Faker());

    // Метод для получения thread-safe Faker
    private static Faker getFaker() {
        return FAKER_THREAD_LOCAL.get();
    }

    public static GamesItem getRandomGame() {
        Faker faker = getFaker(); // Получаем thread-safe Faker

        SimilarDlc similarDlc = SimilarDlc.builder()
                .isFree(false)
                .dlcNameFromAnotherGame(faker.funnyName().name())
                .build();
        DlcsItem dlcsItem = DlcsItem.builder()
                .similarDlc(similarDlc)
                .rating(faker.random().nextInt(10))
                .price(faker.random().nextInt(100))
                .description(faker.funnyName().name())
                .dlcName(faker.dragonBall().character())
                .isDlcFree(true)
                .build();
        Requirements requirements = Requirements.builder()
                .ramGb(faker.random().nextInt(10))
                .videoCard(faker.book().title())
                .hardDrive(faker.random().nextInt(32))
                .osName(faker.animal().name())
                .build();
        return GamesItem.builder()
                .requirements(requirements)
                .genre(faker.book().genre())
                .price(ThreadLocalRandom.current().nextInt(100)) // Используем ThreadLocalRandom
                .description("CS 2")
                .rating(faker.random().nextInt(10))
                .title(faker.book().title())
                .publishDate(LocalDateTime.now().toString())
                .requiredAge(ThreadLocalRandom.current().nextBoolean()) // Используем ThreadLocalRandom
                .tags(Arrays.asList("shooter", "cars"))
                .dlcs(Collections.singletonList(dlcsItem))
                .company(faker.company().name())
                .isFree(false)
                .build();
    }

    public static FullUser getRandomUserWithGames() {
        Faker faker = getFaker(); // Получаем thread-safe Faker

        GamesItem gamesItem = getRandomGame();
        return FullUser.builder()
                .login(faker.name().username() + UUID.randomUUID())
                .pass(faker.internet().password())
                .games(Collections.singletonList(gamesItem))
                .build();
    }

    public static FullUser getRandomUser() {
        int randomNumber = Math.abs(ThreadLocalRandom.current().nextInt()); // Используем ThreadLocalRandom
        return FullUser.builder()
                .login("Unhuman" + UUID.randomUUID())
                .pass("Jumanji" + randomNumber)
                .build();
    }

    public static FullUser getAdminUser() {
        return FullUser.builder()
                .login("admin")
                .pass("admin")
                .build();
    }
}
