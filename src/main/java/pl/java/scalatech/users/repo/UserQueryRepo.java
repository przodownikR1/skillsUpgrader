package pl.java.scalatech.users.repo;

import pl.java.scalatech.cqrsRepo.QueryRepo;
import pl.java.scalatech.users.domain.User;

public interface UserQueryRepo extends QueryRepo<User, Long>, UserQuery{



}
