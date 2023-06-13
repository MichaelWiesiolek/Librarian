package com.example.librarian.dataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

private final UserRepository userRepository;
private final UserService userService;
private final PasswordEncoder passwordEncoder;

@Autowired
public UserH2DataProvider(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        }
@Value("classpath:userIndex.txt")
private Resource resource;
public class UsrH2DataProvider implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String filePathString = resource.getFile().getPath();
        Path of = Path.of(filePathString);
        List<UserEntity> collect = Files.readAllLines(of)
                .stream()
                .map(x -> x.split(","))
                .map(x -> UserEntity
                        .builder()
                        .name(Arrays.stream(x[0].split(" ")).toList().get(0))
                        .surname(Arrays.stream(x[0].split(" ")).toList().get(1))
                        .email(x[1])
                        .phoneNumber(x[2])
                        .password(passwordEncoder.encode(x[3]))
                        .userRole(UserRole.valueOf(x[4]))
                        .build())
                .collect(Collectors.toList());
        userRepository.saveAll(collect);
    }
}
