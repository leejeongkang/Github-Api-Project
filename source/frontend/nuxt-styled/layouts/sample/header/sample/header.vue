<template>
  <header :class="isLnbOpen ? 'open-header' : ''">
    <div class="header" :class="width < 1024 ? 'header-mobile' : ''">
      <div class="header__inner">
        <h1 class="logo">
          <a href="#"><span>로고</span></a>
        </h1>
        <div class="gnb-area">
          <div class="top-bar">
            <ul class="top-menu">
              <li v-if="user === null" class="top-menu__item"><NuxtLink to="/sample/login" class="top-menu__link" href="#">로그인</NuxtLink></li>
              <li v-if="user === null" class="top-menu__item"><a class="top-menu__link" href="#">회원가입</a></li>
              <li v-if="user !== null" class="top-menu__item user-name">
                <a class="top-menu__link" href="#">{{ user.name }}</a>
              </li>
              <li v-if="user !== null" class="top-menu__item"><a class="top-menu__link" href="/logout">로그아웃</a></li>
              <li class="top-menu__item"><locale @changeLocale="onChangeLocale" /></li>
            </ul>
          </div>

          <div class="header-mobile__menu-button" @click="isMobileGnbOpen = true">
            <base-button class="button--icon button--link">
              <svg-icon name="text-align-justify" class="svg-icon" />
              <span class="hidden">메뉴열기</span></base-button
            >
          </div>

          <nav class="nav" :class="isMobileGnbOpen ? 'nav--open' : ''" @mouseleave="isLnbOpen = false">
            <div class="mobile-top-bar">
              <div class="mobile-top-bar__home-button">
                <base-button class="button--link button--icon">
                  <svg-icon name="home" class="svg-icon" />
                  <span class="hidden">처음으로가기</span>
                </base-button>
              </div>
              <ul class="top-menu">
                <li v-if="user === null" class="top-menu__item"><NuxtLink to="/sample/login" class="top-menu__link" href="#">로그인</NuxtLink></li>
                <li v-if="user === null" class="top-menu__item"><a class="top-menu__link" href="#">회원가입</a></li>
                <li v-if="user !== null" class="top-menu__item user-name">
                  <a class="top-menu__link" href="#">{{ user.username }}</a>
                </li>
                <li v-if="user !== null" class="top-menu__item"><a class="top-menu__link" href="/logout">로그아웃</a></li>
                <li class="top-menu__item"><locale @changeLocale="onChangeLocale" /></li>
              </ul>
            </div>
            <div class="header-mobile__close-button" @click="isMobileGnbOpen = false">
              <base-button class="button--icon button--link button--lg">
                <svg-icon name="close" class="svg-icon" />
                <span class="hidden">메뉴닫기</span>
              </base-button>
            </div>
            <ul class="gnb">
              <!--              <li-->
              <!--                class="gnb__item"-->
              <!--                v-for="(item, index) in gnbList"-->
              <!--                @mouseover="[(activeElementIndex = item.index), (isLnbOpen = true)]"-->
              <!--                :class="{ 'gnb__item&#45;&#45;active': activeElementIndex == item.index }"-->
              <!--                :key="index"-->
              <!--              >-->
              <!--                <NuxtLink :to="item.url" class="gnb__link" @focus="isLnbOpen = true">-->
              <!--                  {{ item.title }}-->
              <!--                </NuxtLink>-->
              <!--              </li>-->
              <li class="gnb__item" @mouseover="isLnbOpen = true">
                <NuxtLink to="/" class="gnb__link">{{ $t("nav-title.home") }}</NuxtLink>
              </li>
              <li class="gnb__item" @mouseover="isLnbOpen = true">
                <NuxtLink to="/sample/image?count=20" class="gnb__link">{{ $t("nav-title.image") }}</NuxtLink>
              </li>
              <li class="gnb__item" @mouseover="isLnbOpen = true">
                <NuxtLink to="/sample/search" class="gnb__link">{{ $t("nav-title.search") }}</NuxtLink>
              </li>
              <li class="gnb__item" @mouseover="isLnbOpen = true">
                <a href="#" class="gnb__link">{{ $t("nav-title.data-search") }}</a>
                <ul class="lnb">
                  <li class="lnb__item">
                    <NuxtLink to="/sample/keyword-search" class="lnb__link">{{ $t("nav-title.keyword-search") }}</NuxtLink>
                  </li>
                  <li class="lnb__item">
                    <NuxtLink to="/sample/keyword-search-data-detail" class="lnb__link">{{ $t("nav-title.keyword-search-data-detail") }}</NuxtLink>
                  </li>
                  <li class="lnb__item">
                    <NuxtLink to="/sample/keyword-search-map" class="lnb__link">{{ $t("nav-title.keyword-search-map") }}</NuxtLink>
                  </li>
                </ul>
              </li>
              <li class="gnb__item" @mouseover="isLnbOpen = true">
                <a href="#" class="gnb__link">{{ $t("nav-title.data-registration") }}</a>
                <ul class="lnb">
                  <li class="lnb__item">
                    <NuxtLink to="/sample/data-registration" class="lnb__link">{{ $t("nav-title.data-registration") }}</NuxtLink>
                  </li>
                </ul>
              </li>
            </ul>
          </nav>
          <div class="nav-dim"></div>
        </div>
      </div>
    </div>
  </header>
</template>

<i18n src="./header.json"></i18n>

<script>
import BaseButton from "@component/styled/atoms/base-button/base-button";
import Locale from "@molecules/locale/locale.vue";
import { mapGetters } from "vuex";

export default {
  name: "Header",
  components: {
    BaseButton,
    Locale
  },
  data() {
    return {
      activeElementIndex: 0,
      width: 0,
      isLnbOpen: false,
      isMobileGnbOpen: false
    };
  },
  computed: {
    ...mapGetters({
      user: "user"
    })
  },
  mounted() {
    window.addEventListener("resize", this.checkResize);
  },
  destroyed() {
    window.removeEventListener("resize", this.checkResize);
  },
  methods: {
    checkResize(event) {
      this.width = window.innerWidth;
    },
    onChangeLocale(param) {
      this.$i18n.setLocale(param);
    }
  }
};
</script>

<style lang="scss" scoped>
@import "./header";
</style>
