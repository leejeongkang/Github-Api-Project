<template lang="html">
  <footer>
    <div class="footer-top">
      <div class="footer-top__inner">
        <div class="footer-top__list">
          <ul>
            <li class="footer-top__item" v-for="(item, index) in menuList" :key="index">
              <a href="#" class="footer-top__item-text" title="menu1">{{ item.title }}</a>
            </li>
          </ul>
        </div>
        <div class="footer-top__family-site">
          <div class="select select--lg" :class="isSelectOpen ? 'select--open' : ''"
               @click="isSelectOpen = !isSelectOpen">
            <div class="select-selector">
              <button class="select-selector__button">
                <span class="select-selector__title">관련사이트</span>
                <svg-icon class="svg-icon select-selector__icon" name="chevron-down-medium"
                          aria-hidden="true"></svg-icon>
              </button>
            </div>
            <div class="select-container">
              <ul class="select-container__list">
                <li class="select-container__item" value="1" v-for="(item, index) in familyList" :key="index">
                  <button class="select-container__button" type="button">
                    <span class="select-container__text">{{ item.title }}</span>
                  </button>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer-bottom">
      <div class="footer-bottom__inner">
        <div class="logo"><img :src="$t('footer.company-logo')"/></div>
        <div class="footer-bottom__info">
          <address>
            <p class="footer-bottom__text-line">본사 (05854) {{ $t("footer.company-address") }}</p>
            <p class="footer-bottom__text-line"><span class="footer-bottom__info-text">TEL :
                  {{ $t("footer.company-tel") }}</span><span
              class="footer-bottom__info-sect">/</span><span>FAX : {{ $t("footer.company-fax") }}</span><span
              class="footer-bottom__info-sect">/</span><span class="footer-bottom__info-sect">E-mail :
                  {{ $t("footer.company-mail") }}</span></p>
          </address>
          <p class="footer-bottom__copyright">
            <span class="footer-bottom__info-text">{{ $t("footer.company-copyright") }}</span>
          </p>
        </div>
      </div>
    </div>
  </footer>
</template>

<i18n src="./footer.json"></i18n>

<script type="text/javascript">
export default {
  name: "Footer",
  data() {
    return {
      isSelectOpen: false,
      menuList: [
        {
          index: 0,
          title: 'menu1',
        },
        {
          index: 1,
          title: 'menu2',
        },
        {
          index: 2,
          title: 'menu3',
        },
        {
          index: 3,
          title: 'menu4',
        },
        {
          index: 4,
          title: 'menu5',
        }
      ],
      familyList: [
        {
          index: 0,
          title: 'site1',
        },
        {
          index: 1,
          title: 'site2',
        },
        {
          index: 2,
          title: 'site3',
        },
        {
          index: 3,
          title: 'site4',
        },
        {
          index: 4,
          title: 'site5',
        }
      ]
    }
  }
};
</script>

<style lang="scss" scoped>
@import "./footer";
</style>

