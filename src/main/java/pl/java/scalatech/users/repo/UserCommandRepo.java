package pl.java.scalatech.users.repo;

import pl.java.scalatech.cqrsRepo.CommandRepo;
import pl.java.scalatech.users.domain.User;

public interface UserCommandRepo extends CommandRepo<User, Long>{

}
