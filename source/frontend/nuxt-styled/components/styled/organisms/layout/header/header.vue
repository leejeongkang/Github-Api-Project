<template>
<!--  isMobileGnbOpen일 경우, 상위 body에 no-scroll 클래스 추가-->
  <header :class='isLnbOpen ? "open-header" : ""' >
    <div class="header" :class="width < 1024 ? 'header-mobile':''">
      <div class="header__inner">
        <h1 class="logo"><a href="#"><span>로고</span></a></h1>
        <div class="gnb-area">
          <div class="top-bar">
            <ul class="top-menu">
              <!-- 로그인 전 -->
              <li class="top-menu__item"><a class="top-menu__link" href="#">로그인</a></li>
              <li class="top-menu__item"><a class="top-menu__link" href="#">회원가입</a></li>
            </ul>
          </div>

          <div class="header-mobile__menu-button" @click="isMobileGnbOpen = true">
            <base-button class="button--icon button--link">
              <svg-icon name="text-align-justify" class="svg-icon "/>
              <span class="hidden">메뉴열기</span></base-button>
          </div>

          <nav class="nav" :class="isMobileGnbOpen ? 'nav--open': ''" @mouseleave="isLnbOpen = false">
            <div class="mobile-top-bar">
              <div class="mobile-top-bar__home-button">
                <base-button class="button--link button--icon">
                  <svg-icon name="home" class="svg-icon"/>
                  <span class="hidden">처음으로가기</span>
                </base-button>
              </div>
              <ul class="top-menu">
                <!-- 로그인 후 -->
                <li class="top-menu__item user-name"><a class="top-menu__link" href="#">홍길동님</a></li>
                <li class="top-menu__item"><a class="top-menu__link" href="#">로그아웃</a></li>
                <!-- //로그인 후 -->
              </ul>
            </div>
            <div class="header-mobile__close-button" @click="isMobileGnbOpen = false">
              <base-button class="button--icon button--link button--lg">
                <svg-icon name="close" class="svg-icon"/>
                <span class="hidden">메뉴닫기</span>
              </base-button>
            </div>
            <ul class="gnb">
              <li class="gnb__item" v-for="(item, index) in gnbList"
                  @mouseover="[activeElementIndex = item.index, isLnbOpen = true]"
                  :class="{'gnb__item--active' : activeElementIndex == item.index}"
                  :key="index">
                <a href="#" class="gnb__link" @focus="isLnbOpen = true">
                  {{ item.title }}
                  <svg-icon name="chevron-down" class="svg-icon gnb__arrow-icon"/>
                </a>
                <ul class="lnb">
                  <li class="lnb__item" v-for="(lnbItem, lnbIndex) in item.lnbList" :key="lnbIndex">
                    <a href="#" class="lnb__link">
                      {{ lnbItem.title }}
                    </a>
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

<script>
import BaseButton from "@component/styled/atoms/base-button/base-button";

export default {
  name: "Header",
  data() {
    return {
      activeElementIndex: 0,
      width: 0,
      isLnbOpen: false,
      isMobileGnbOpen: false,
      gnbList: [
        {
          index: 0,
          title: '데이터 검색',
          lnbList: [
            {title: '서브메뉴1'},
            {title: '서브메뉴2'},
            {title: '서브메뉴3'},
            {title: '서브메뉴4'},
          ]
        },
        {
          index: 1,
          title: '데이터 등록',
          lnbList: [
            {title: '서브메뉴1'},
            {title: '서브메뉴2'},
            {title: '서브메뉴3'},
            {title: '서브메뉴2'}
          ]
        },
        {
          index: 2,
          title: '데이터 분석활용',
          lnbList: [
            {title: '서브메뉴1'},
            {title: '서브메뉴3'},
            {title: '서브메뉴2'}
          ]
        },
        {
          index: 3,
          title: '커뮤티니',
          lnbList: [
            {title: '서브메뉴1'},
            {title: '서브메뉴2'}
          ]
        },
        {
          index: 4,
          title: '이용안내',
          lnbList: [
            {title: '서브메뉴1'},
            {title: '서브메뉴3'},
            {title: '서브메뉴3'},
            {title: '서브메뉴3'},
            {title: '서브메뉴2'}
          ]
        }
      ]
    }
  },
  mounted() {
    window.addEventListener('resize', this.checkResize);
  },
  destroyed() {
    window.removeEventListener('resize', this.checkResize);
  },
  methods: {
    checkResize(event) {
      this.width = window.innerWidth;
    }
  },
  components: {
    BaseButton
  }
};
</script>

<style lang="scss" scoped>
@import "./header";
</style>
