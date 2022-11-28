import Footer from "./footer.vue";
import {PageHeader} from "@component/styled/organisms/layout/header/header.stories";

export default {
  title: 'Styled/Organisms/[PCFC] 페이지 푸터',
  component: Footer,
  decorators: [() => ({template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) Footer </h2><story /></div>'})],
};

export const Default = () => ({
  components: {Footer},
  template: '<Footer></Footer>'
});
