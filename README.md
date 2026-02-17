# ShortReels 🎬

Una aplicación de videos verticales cortos tipo Dramabox / Melolo / Netshort.

## 🏗 Arquitectura

**MVVM + Clean Architecture + Repository Pattern**

```
com.shortreels/
├── data/
│   ├── local/          # Room Database (DAOs, Entities)
│   ├── remote/         # Retrofit API + DTOs
│   └── repository/     # Repositories (single source of truth)
├── domain/
│   ├── usecases/       # Business logic use cases
│   └── interfaces/     # Abstractions
├── ui/
│   ├── auth/           # Login / Register
│   ├── feed/           # Feed vertical de videos
│   ├── player/         # Reproductor fullscreen
│   ├── explore/        # Búsqueda y descubrimiento
│   ├── profile/        # Perfil de usuario
│   ├── premium/        # Suscripción y monedas
│   ├── upload/         # Subir videos
│   └── notifications/  # Notificaciones
├── di/                 # Hilt Dependency Injection
├── services/           # Foreground services (playback)
├── utils/              # Utilidades (Kotlin + Java)
└── workers/            # WorkManager workers
```

## 📦 Stack Tecnológico

| Categoría          | Tecnología                          |
|--------------------|-------------------------------------|
| Lenguaje           | **Kotlin + Java** (interop)         |
| DI                 | **Hilt** (Dagger 2)                 |
| Arquitectura       | **MVVM + Repository**               |
| Navegación         | **Navigation Component**            |
| UI                 | **ViewBinding + Material Design 3** |
| Reproductor        | **ExoPlayer / Media3**              |
| Red                | **Retrofit 2 + OkHttp 4**           |
| Base de datos      | **Room**                            |
| Caché              | **DataStore Preferences**           |
| Imágenes           | **Glide 4**                         |
| Async              | **Coroutines + Flow**               |
| Tareas background  | **WorkManager**                     |
| Animaciones        | **Lottie + Material Animations**    |

## 🚀 Setup

1. **Clonar el proyecto**
```bash
git clone https://github.com/tu-usuario/ShortReels.git
```

2. **Añadir fuentes** (en `app/src/main/res/font/`)
- Descarga [Bebas Neue](https://fonts.google.com/specimen/Bebas+Neue)
- Descarga [Outfit](https://fonts.google.com/specimen/Outfit)

3. **Configurar API** en `app/build.gradle`:
```groovy
buildConfigField "String", "BASE_URL", '"https://tu-api.com/v1/"'
```

4. **Compilar**
```bash
./gradlew assembleDebug
```

## 📱 Funcionalidades

### Feed Principal
- ✅ Scroll vertical tipo TikTok / Dramabox
- ✅ Autoplay en vista
- ✅ Tabs: Para Ti / Siguiendo / Tendencia
- ✅ Doble tap para dar like con animación
- ✅ Compartir, guardar, comentar
- ✅ Contenido premium con bloqueo

### Reproductor
- ✅ ExoPlayer con Media3
- ✅ Servicio en background
- ✅ Controles de reproducción
- ✅ Mutear/desmutear

### Explorar
- ✅ Búsqueda en tiempo real (debounce 400ms)
- ✅ Grid de géneros
- ✅ Series en tendencia
- ✅ Historial de búsqueda

### Perfil
- ✅ Estadísticas del usuario
- ✅ Sistema de monedas
- ✅ Badge de premium
- ✅ Editar perfil

### Autenticación
- ✅ Login / Registro con validación
- ✅ DataStore para sesión persistente
- ✅ Interceptor de autenticación (Bearer token)
- ✅ Explorar sin cuenta

### Descargas
- ✅ WorkManager para descargas en background
- ✅ Retry automático (max 3 intentos)
- ✅ DownloadManager en Java (interop)

### Base de Datos Local
- ✅ Cache de videos (Room)
- ✅ Historial de visualización
- ✅ Videos guardados
- ✅ Historial de búsqueda
- ✅ Perfil de usuario cacheado

## 🌍 API Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /auth/login | Iniciar sesión |
| POST | /auth/register | Registrarse |
| GET | /feed/foryou | Feed para ti |
| GET | /feed/following | Feed siguiendo |
| GET | /feed/trending | Tendencia |
| POST | /videos/{id}/like | Dar like |
| GET | /series | Lista de series |
| GET | /search | Búsqueda |
| GET | /premium/plans | Planes premium |

## 🎨 Diseño

**Tema oscuro** con paleta de colores:
- Primary: `#FF3C6E` (Rosa-Rojo)
- Secondary: `#9B5DFF` (Púrpura)
- Accent: `#00E5FF` (Cyan)
- Gold: `#FFD700` (Premium)
- Background: `#0A0A0F` (Negro profundo)

## 📋 Módulos Java (interop con Kotlin)

- `VideoPlaybackService.java` - Servicio Media3
- `EpisodeListAdapter.java` - Adaptador RecyclerView
- `NumberUtils.java` - Formateo de números
- `NetworkUtils.java` - Estado de conectividad
- `DateUtils.java` - Formateo de fechas
- `DownloadManager.java` - Gestión de descargas

## 🔐 Seguridad

- HTTPS obligatorio en producción
- Token Bearer en headers
- ProGuard/R8 en release
- No se almacenan contraseñas en local
- DataStore encriptado para tokens

## 📊 Estructura del Proyecto

```
ShortReels/
├── app/
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/shortreels/   (Kotlin + Java)
│       └── res/
│           ├── layout/            (32+ layouts)
│           ├── drawable/          (gradients, shapes, icons)
│           ├── navigation/        (nav_graph.xml)
│           ├── menu/              (bottom_nav_menu.xml)
│           ├── values/            (colors, strings, themes, dimens)
│           ├── anim/              (animations)
│           └── font/              (Bebas Neue, Outfit)
├── build.gradle
├── settings.gradle
└── gradle.properties
```
