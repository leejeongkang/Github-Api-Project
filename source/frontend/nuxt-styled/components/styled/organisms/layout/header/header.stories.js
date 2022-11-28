import Header from "./header.vue";

export default {
  title: 'Styled/Organisms/[PCFI] 페이지 해더',
  component: Header,
  decorators: [() => ({template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 헤더 </h2><story /></div>'})],
};

export const Default = () => ({
  components: { Header },
  template: '<Header></Header>'
});
