<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![Quality][quality-shield]][quality-url]

<!-- PROJECT LOGO -->
<!--suppress ALL -->
<br />
<p align="center">
  <a href="https://github.com/LeoMeinel/VitalEnchant">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">VitalEnchant</h3>

  <p align="center">
    Enchant items on Spigot and Paper
    <br />
    <a href="https://github.com/LeoMeinel/VitalEnchant"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/LeoMeinel/VitalEnchant">View Demo</a>
    ·
    <a href="https://github.com/LeoMeinel/VitalEnchant/issues">Report Bug</a>
    ·
    <a href="https://github.com/LeoMeinel/VitalEnchant/issues">Request Feature</a>
  </p>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#description">Description</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#commands-and-permissions">Commands and Permissions</a></li>
        <li><a href="#configuration - config.yml">Configuration</a></li>
		<li><a href="#configuration - messages.yml">Configuration</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

### Description

VitalEnchant is a Plugin that gives players the ability to enchant items.

This plugin is perfect for any server wanting to apply custom enchants to items.

### Features

* Enchant items

### Built With

* [Gradle 7](https://docs.gradle.org/7.4/release-notes.html)
* [OpenJDK 17](https://openjdk.java.net/projects/jdk/17/)

<!-- GETTING STARTED -->

## Getting Started

To get the plugin running on your server follow these simple steps.

### Commands and Permissions

1. Permission: `vitalenchant.enchant`

* Command: `/enchant <enchantment> <level>`
* Description: Enchant item

### Configuration - config.yml

```
max-level: 50
```

### Configuration - messages.yml

```
cmd: "&fUsage: &b/enchant <enchantment> <level>"
no-perms: "&cYou don't have enough permissions!"
player-only: "&cThis command can only be executed by players!"
invalid-item: "&cInvalid item!"
invalid-enchant: "&cInvalid enchantment!"
invalid-amount: "&cInvalid amount!"
max-level: "&cInvalid level!"
```

<!-- ROADMAP -->

## Roadmap

See the [open issues](https://github.com/LeoMeinel/VitalEnchant/issues) for a list of proposed features (and known
issues).

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to be, learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->

## License

Distributed under the GNU General Public License v3.0. See `LICENSE` for more information.

<!-- CONTACT -->

## Contact



Leopold Meinel - [leo@meinel.dev](mailto:leo@meinel.dev) - eMail

Project Link - [VitalEnchant](https://github.com/LeoMeinel/VitalEnchant) - GitHub

<!-- ACKNOWLEDGEMENTS -->

### Acknowledgements

* [README.md - othneildrew](https://github.com/othneildrew/Best-README-Template)

<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors-anon/LeoMeinel/VitalEnchant?style=for-the-badge

[contributors-url]: https://github.com/LeoMeinel/VitalEnchant/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/LeoMeinel/VitalEnchant?label=Forks&style=for-the-badge

[forks-url]: https://github.com/LeoMeinel/VitalEnchant/network/members

[stars-shield]: https://img.shields.io/github/stars/LeoMeinel/VitalEnchant?style=for-the-badge

[stars-url]: https://github.com/LeoMeinel/VitalEnchant/stargazers

[issues-shield]: https://img.shields.io/github/issues/LeoMeinel/VitalEnchant?style=for-the-badge

[issues-url]: https://github.com/LeoMeinel/VitalEnchant/issues

[license-shield]: https://img.shields.io/github/license/LeoMeinel/VitalEnchant?style=for-the-badge

[license-url]: https://github.com/LeoMeinel/VitalEnchant/blob/main/LICENSE

[quality-shield]: https://img.shields.io/codefactor/grade/github/LeoMeinel/VitalEnchant?style=for-the-badge

[quality-url]: https://www.codefactor.io/repository/github/LeoMeinel/VitalEnchant
