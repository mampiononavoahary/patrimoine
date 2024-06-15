package school.hei.patrimoine.possession;

import java.time.Instant;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public final class GroupePossession extends Possession {

  private final Set<Possession> possessions;

  public GroupePossession(String nom, Instant t, Set<Possession> possessions) {
    super(nom, t, possessions.stream().mapToInt(Possession::getValeurComptable).sum());
    this.possessions = possessions;
  }

  @Override
  public Possession projectionFuture(Instant tFutur) {
    return new GroupePossession(
        nom, tFutur, possessions.stream().map(p -> p.projectionFuture(tFutur)).collect(toSet()));
  }
}
