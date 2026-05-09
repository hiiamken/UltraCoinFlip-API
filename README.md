<div align="center">

# UltraCoinFlip API

**Public API for [UltraCoinFlip](https://www.spigotmc.org/resources/ultracoinflip.00000/) — integrate other plugins with the coinflip system.**

[![Java](https://img.shields.io/badge/Java-8+-orange)](https://www.java.com/)
[![Discord](https://img.shields.io/badge/Discord-Support-7289DA)](https://discord.gg/h7F7GysXCf)
[![JitPack](https://img.shields.io/jitpack/version/com.github.hiiamken/UltraCoinFlip-API)](https://jitpack.io/#hiiamken/UltraCoinFlip-API)

</div>

---

## What is this?

This repository hosts only the **public API surface** of UltraCoinFlip — a small set of interfaces, events, and DTOs that other plugins compile against. The actual plugin runtime lives in its own (private) repository and is distributed via [SpigotMC](https://www.spigotmc.org/resources/ultracoinflip.00000/) and [Modrinth](https://modrinth.com/).

Use this library when you want to:

- Listen to coinflip game lifecycle events (create / join / finish / refund / cancel)
- Read player earnings limits, active games, currencies
- Cancel or reject games as part of an anti-cheat or compliance plugin

## Installation

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.hiiamken</groupId>
    <artifactId>UltraCoinFlip-API</artifactId>
    <version>5.0.0</version>
    <scope>provided</scope>
</dependency>
```

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.hiiamken:UltraCoinFlip-API:5.0.0'
}
```

### plugin.yml

```yaml
depend: [UltraCoinFlip]
```

## Listening to events

```java
import com.kstudio.ultracoinflip.api.event.CoinFlipFinishEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MyListener implements Listener {
    @EventHandler
    public void onFinish(CoinFlipFinishEvent e) {
        if (e.getPayout() > 1_000_000) {
            // big win — broadcast, log, whatever you need
        }
    }
}
```

## Reading plugin state

```java
import com.kstudio.ultracoinflip.api.UltraCoinFlipAPI;
import com.kstudio.ultracoinflip.api.limit.LimitType;

UltraCoinFlipAPI api = UltraCoinFlipAPI.get();
int activeGames = api.getActiveGameCount();

api.getEarningsLimit(playerUuid, "vault", LimitType.MAX_WIN).ifPresent(info -> {
    double remaining = info.getRemaining();
});
```

## Available events

| Event | Cancellable | Fires when |
|---|---|---|
| `CoinFlipPreCreateEvent` | yes | before a game is registered |
| `CoinFlipCreateEvent` | no | after a game is registered |
| `CoinFlipPreJoinEvent` | yes | before a player joins |
| `CoinFlipJoinEvent` | no | after a player joins |
| `CoinFlipPreResolveEvent` | yes | before payout (last-chance hook) |
| `CoinFlipFinishEvent` | no | after payout |
| `CoinFlipRefundEvent` | no | when a bet is refunded |
| `CoinFlipCancelEvent` | no | when a game is cancelled |
| `CoinFlipEarningsLimitReachedEvent` | no | when a player first crosses a cap |

## Versioning

The `com.kstudio.ultracoinflip.api.*` package is frozen on the v5.x line — methods may be added, existing signatures stay stable. Breaking changes ship in a new major version (v6.0).

## Support

- **Discord**: [discord.gg/h7F7GysXCf](https://discord.gg/h7F7GysXCf)
- **Issues**: [GitHub Issues](https://github.com/hiiamken/UltraCoinFlip-API/issues)

---

**Made by [hiiamken](https://github.com/hiiamken)**
