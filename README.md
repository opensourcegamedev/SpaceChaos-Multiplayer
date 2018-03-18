# SpaceChaos Multiplayer

[![Build Status](https://travis-ci.org/opensourcegamedev/SpaceChaos-Multiplayer.svg?branch=master)](https://travis-ci.org/opensourcegamedev/SpaceChaos-Multiplayer)
[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=de.spacechaos%3Aspacechaos-multiplayer)](https://sonarcloud.io/dashboard/index/de.spacechaos%3Aspacechaos-multiplayer) 
[![Waffle.io - Columns and their card count](https://badge.waffle.io/opensourcegamedev/SpaceChaos-Multiplayer.png?columns=Inbox,Next,In%20Progress,Done)](https://waffle.io/opensourcegamedev/SpaceChaos-Multiplayer?utm_source=badge)
[![Coverage](https://sonarcloud.io/api/badges/measure?key=de.spacechaos%3Aspacechaos-multiplayer&metric=coverage)](https://sonarcloud.io/dashboard/index/de.spacechaos%3Aspacechaos-multiplayer) 
[![Technical Debt Rating](https://sonarcloud.io/api/badges/measure?key=de.spacechaos%3Aspacechaos-multiplayer&metric=sqale_debt_ratio)](https://sonarcloud.io/dashboard/index/de.spacechaos%3Aspacechaos-multiplayer) 
[![JUnit Tests Rating](https://sonarcloud.io/api/badges/measure?key=com.jukusoft.mmo%3Ammorpg-client&metric=test_success_density)](https://sonarcloud.io/dashboard/index/de.spacechaos%3Aspacechaos-multiplayer) 
[![Security Rating](https://sonarcloud.io/api/badges/measure?key=de.spacechaos%3Aspacechaos-multiplayer&metric=new_security_rating)](https://sonarcloud.io/dashboard/index/de.spacechaos%3Aspacechaos-multiplayer) 


Im Rahmen dieses Projekts wollen wir einen Multiplayer-Modus für unser [voriges Projekt](https://github.com/opensourcegamedev/SpaceChaos) entwickeln.  Dabei ist der Weg das Ziel - wir entwickeln das Projekt hauptsächlich, um uns mit verschiedenen Programmieransätzen und Problematiken auseinanderzusetzen.

![SpaceChaos Logo](./core/assets/ui/backgrounds/splashscreen.png)

## Technik 
Das Spiel ist in Java geschrieben und verwendet als Engine das [libGDX](https://libgdx.badlogicgames.com/)-Framework. Für die Physik-Simulation wird Box2D (in der in libGDX integrierten Fassung) verwendet. 
Als Entity-Component-System greifen wir auf das bewährte [artemis-odb](https://github.com/junkdog/artemis-odb) zurück.
Für den Netzwerk-Teil des Spiels setzen wir auf [vertx.io](http://vertx.io/).

## Contributors & externe Assets
Eine Übersicht über alle bisherigen Contributor und die genutzten externen Assets gibt es in der [CONTRIBUTORS.md](https://github.com/opensourcegamedev/SpaceChaos-Multiplayer/blob/master/CONTRIBUTORS.md).

## Wo kann ich mehr erfahren
Weitere Informationen zum Spiel sind auf unserer Webseite [spacechaos.de](http://spacechaos.de/), sowie auf unserem [Spieleprofil](https://pewn.de/games/815998-SpaceChaos/) auf Pewn zu finden.

<a href="https://pewn.de/games/815998-SpaceChaos/?vote=notify"><img src="https://pewn.de/signature/pewn3_general.png" alt="Unser Spiel auf Pewn"/></a>
