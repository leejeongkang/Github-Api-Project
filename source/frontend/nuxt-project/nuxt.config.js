import { resolve } from "path";

//  logger 설정 --
function _interopDefaultLegacy(e) {
  return e && typeof e === "object" && "default" in e ? e : { default: e };
}
const consola__default = /*#__PURE__*/ _interopDefaultLegacy(consola);
const logger = consola__default["default"];
// -- logger 설정

function _routeAlias (route) {
  if (route.path === undefined) {
    return;
  }

  let alias =
    route.path.length > 1 ? `${route.path}/index.html` : "/index.html";
  route.alias = alias;

  logger.info(route.path + "---------------");
  for (var key in route) {
    if (key !== "children")
      logger.info("----" + key + " [" + route[key] + "]");
  }
}

export default {
  ssr: true, // process.env.ENV_TYPE === "product" ? true : false,

  // Target: https://go.nuxtjs.dev/config-target
  target: "static",

  // generate
  generate: {
    cache: false,
    crawler: true,
    routes: ["/"],
    dir: "../../src/main/resources/static"
  },

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: "IRIS Web Development Framework",
    htmlAttrs: {
      lang: "en"
    },
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      { hid: "description", name: "description", content: "" }
    ],
    link: [{ rel: "icon", type: "image/x-icon", href: "/favicon.ico" }]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: ["~/assets/main.scss"],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: ["~/plugins/axios.js", "~/plugins/persisted-state.client.js", "~plugins/vue-js-modal.js"],

  // Auto import components: https://go.nuxtjs.dev/config-components
  // components: [
  //   { path: "~/components/functional", extensions: ["vue"] },
  //   { path: "~/components/project", extensions: ["vue"] }
  // ],
  components: false,

  loading: "~/components/functional/loader/loader.vue",

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    "@nuxtjs/dotenv",
    "@nuxtjs/proxy",
    "@nuxtjs/axios",
    "@nuxtjs/style-resources",
    "@nuxtjs/svg-sprite",
    "@nuxtjs/i18n",
    "@nuxtjs/fontawesome",
    "nuxt-webpack-optimisations"
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: ["cookie-universal-nuxt"],

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
    postcss: {
      preset: {
        features: {
          "custom-properties": false
        }
      }
    },
    html: {
      minify: {
        minifyCSS: process.env.ENV_TYPE === "product",
        minifyJS: process.env.ENV_TYPE === "product"
      }
    },
    optimization: {
      minimize: process.env.ENV_TYPE === "product"
    },
    cssSourceMap: process.env.ENV_TYPE === "product"
  },

  // nuxt webpack-optimizations
  webpackOptimisations: {
    features: {
      imageFileLoader: false
    }
  },

  server: {
    host: "localhost",
    port: 4000
  },

  // alias
  alias: {
    "@component": resolve(__dirname, "./components"),
    "@styled": resolve(__dirname, "./components/styled"),
    "@functional": resolve(__dirname, "./components/functional"),
    "@project": resolve(__dirname, "./components/project"),
    "@atoms": resolve(__dirname, "./components/styled/atoms"),
    "@molecules": resolve(__dirname, "./components/styled/molecules"),
    "@organisms": resolve(__dirname, "./components/styled/organisms"),
    "@template": resolve(__dirname, "./components/styled/template")
  },

  // plugin-options
  svgSprite: {
    input: "~/assets/style/images/icon"
  },

  axios: {
    baseURL: process.env.ENV_TYPE === "development" ? "http://localhost:80/" : "/",
    credentials: true,
    progress: false
  },

  i18n: {
    locales: [
      { code: "en", iso: "en-US", file: "en.json" },
      { code: "ko", iso: "ko-KR", file: "ko.json" }
    ],
    defaultLocale: "ko",
    vueI18n: {
      fallbackLocale: "ko"
    },
    langDir: "locales/",
    vueI18nLoader: true
  },

  router: {
    extendRoutes(routes) {
      logger.info("## NuxtLink 처리: 정적 리소스에 대한 html 파일 대응을 위해 아래와 같이 alias 경로를 변경 합니다.");
      routes.forEach((route) => {
        _routeAlias (route);

        // children url 처리
        if (route.children !== undefined) {
          route.children.forEach((child) => {
            _routeAlias (child);
          });
        }
      });
    }
  },

  styleResources: {
    scss: ["~/assets/main.scss"]
  },

  fontawesome: {
    component: "fa",
    icons: {
      solid: true,
      brands: true
    }
  }
};
