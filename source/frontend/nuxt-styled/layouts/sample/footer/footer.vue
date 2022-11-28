<template lang="html">
  <footer>
    <div class="footer-top">
      <div class="footer-top__inner">
        <div class="footer-top__list">
          <ul>
            <li class="footer-top__item">
              <NuxtLink to="/" class="footer-top__item-text" :title="$t('footer.nav.home')">
                {{ $t("footer.nav.home") }}
              </NuxtLink>
            </li>
            <li class="footer-top__item">
              <a href="https://www.data.go.kr/ugs/selectPortalPolicyView.do#use_stplat" target="_blank" class="footer-top__item-text" :title="$t('footer.nav.terms')">
                {{ $t("footer.nav.terms") }}
              </a>
            </li>
            <li class="footer-top__item">
              <a href="https://www.data.go.kr/ugs/selectPortalPolicyView.do#use_stplat" target="_blank" class="footer-top__item-text" :title="$t('footer.nav.privacy-policy')">
                {{ $t("footer.nav.privacy-policy") }}
              </a>
            </li>
            <li class="footer-top__item">
              <a href="https://www.data.go.kr/ugs/selectPortalPolicyView.do" target="_blank" class="footer-top__item-text" :title="$t('footer.nav.copyright-policy')">
                {{ $t("footer.nav.copyright-policy") }}
              </a>
            </li>
            <li class="footer-top__item">
              <a :href="'mailto:' + $t('footer.company-mail')" class="footer-top__item-text" :title="$t('footer.nav.personal-center')">
                {{ $t("footer.nav.personal-center") }}
              </a>
            </li>
          </ul>
        </div>
        <div class="footer-top__family-site">
          <div class="select select--lg" :class="isSelectOpen ? 'select--open' : ''" @click="isSelectOpen = !isSelectOpen">
            <div class="select-selector">
              <button class="select-selector__button">
                <span class="select-selector__title">{{ selectedFamilySite.title }}</span>
                <svg-icon class="svg-icon select-selector__icon" name="chevron-down-medium" aria-hidden="true"></svg-icon>
              </button>
            </div>
            <div class="select-container">
              <ul class="select-container__list">
                <li class="select-container__item" v-for="(item, index) in familyList" :key="index">
                  <button class="select-container__button" type="button" @click="onSelectFamilySize(item)">
                    <span class="select-container__text">{{ item.title }}</span>
                  </button>
                </li>
              </ul>
            </div>
          </div>
          &nbsp;
          <div class="footer-top__button">
            <button class="button button--tertiary button--lg" @click="onClickMoveRelativeSize">
              <span>{{ $t("footer.move") }}</span>
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="footer-bottom">
      <div class="footer-bottom__inner">
        <div class="logo"><img :src="$t('footer.company-logo')" /></div>
        <div class="footer-bottom__info">
          <address>
            <p class="footer-bottom__text-line">본사 (05854) {{ $t("footer.company-address") }}</p>
            <p class="footer-bottom__text-line">
              <span class="footer-bottom__info-text">TEL : {{ $t("footer.company-tel") }}</span
              ><span class="footer-bottom__info-sect">/</span><span>FAX : {{ $t("footer.company-fax") }}</span
              ><span class="footer-bottom__info-sect">/</span><span class="footer-bottom__info-sect">E-mail : {{ $t("footer.company-mail") }}</span>
            </p>
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
import FamilySite from "./footer.familysite.json";
import { errorAlert } from "@functional/alert/alert-default";

export default {
  name: "Footer",
  data() {
    return {
      isSelectOpen: false,
      selectedFamilySite: {
        title: this.$t("footer.relative-site")
      }
    };
  },
  computed: {
    familyList() {
      return FamilySite;
    }
  },
  methods: {
    onSelectFamilySize(item) {
      this.selectedFamilySite = item;
    },
    async onClickMoveRelativeSize() {
      let url = this.selectedFamilySite.url;
      if (url === undefined) {
        await errorAlert(this.$t("footer.error-relative-site"));
        return;
      }

      window.open(url);
    }
  }
};
</script>

<style lang="scss" scoped>
@import "./footer";
</style>
