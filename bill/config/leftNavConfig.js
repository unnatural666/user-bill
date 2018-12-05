let navConfig = {
  'home' : '0',
  'lobby' : '1',
  'buy' : '2-0',
  'sale' : '2-1',
  'login' : '2-2',
  'user' : '3',
};

function getActiveNav(href) {
  let key = href.split('/')[1];
  return navConfig[key];
};

export default getActiveNav;

